/**
 * 封装的IndexedDb模块。
 */
angular.module("indexDB", [])
  .service("indexDBService", function($ionicPopup) {
    //定义数据库的基本信息
    /**数据库的基本信息。*/
    this.database = {
      /**数据库名称。*/
      name: "MallApp",
      /**数据库版本号，使用整数。*/
      version: 2046,
      /**数据库实例。*/
      instance: {},
      /**错误处理器。*/
      errorHandler: function(error) {
        console.log(`error: ${error.target.error.message}`);
      },
      /**打开数据库连接。*/
      open: function(callback, onerror) {
        let dbContent = window.indexedDB.open(database.name, database.version);
        dbContent.onupgradeneeded = database.upgrade;
        dbContent.onerror = database.errorHandler;
        dbContent.onsuccess = function() {
          database.instance = dbContent.result;
          database.instance.onerror = onerror;
          callback();
        };
      },
      /**数据库版本更新操作。*/
      //如果数据库名称和版本号相同，那么该方法只会执行一次，执行完之后会自动执行onsuccess方法
      upgrade: function(event) {
        //获取数据库对象
        let db = event.target.result;
        //获取数据库实例中所有的Object Store的名字
        let storeNames = db.objectStoreNames;
        let name = "cart";
        //如果不存在则创建，并设置键的路径和是否自增
        if(!storeNames.contains(name)) {
          db.createObjectStore(name, {
            keyPath: "id",
            autoIncrement: true
          });
        }
      },
      /**获取Object Store对象。*/
      getObjectStore: function(objectStoreName, mode = "readonly") {
        let tx = database.instance.transaction([objectStoreName], mode);
        let store = tx.objectStore(objectStoreName);
        return store;
      },
      /**更新数据。*/
      update: function(objectStoreName, data, onsuccess, onerror) {
        database.open(function() {
          let store = database.getObjectStore(objectStoreName, "readwrite");
          let req = store.put(data);
          req.onsuccess = onsuccess;
          req.onerror = onerror;
        }, onerror);
      },
      /**获取单条数据。*/
      get: function(objectStoreName, id, onsuccess, onerror) {
        database.open(function() {
          let store = database.getObjectStore(objectStoreName);
          let req = store.get(id);
          req.onsuccess = onsuccess; //e=>onsuccess(e.target.result)
          req.onerror = onerror;
        });
      },
      /**获取全部数据。*/
      getAll: function(objectStoreName, onsuccess, onerror) {
        database.open(function() {
          let store = database.getObjectStore(objectStoreName);
          let cursor = store.openCursor();
          let data = [];
          cursor.onsuccess = function(event) {
            let result = event.target.result;
            if(result) {
              data.push(result.value);
              result.continue();
            } else {
              onsuccess(data);
            }
          };
          cursor.onerror = onerror;
        }, onerror);
      }
    }
  });

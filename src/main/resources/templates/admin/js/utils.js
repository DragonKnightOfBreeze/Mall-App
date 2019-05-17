//弹出右键菜单，用于显示或隐藏表格中的列
function createGridHeaderContextMenu(e, field) {
  e.preventDefault();
  let grid = $(this);/* grid本身 */
  let headerContextMenu = this.headerContextMenu;/* grid上的列头菜单对象 */
  let okCls = 'tree-checkbox1';// 选中
  let emptyCls = 'tree-checkbox0';// 取消
  if(!headerContextMenu) {
    let tmenu = $('<div style="width:100px;"></div>').appendTo('body');
    let fields = grid.datagrid('getColumnFields');
    for(let i = 0; i < fields.length; i++) {
      let fildOption = grid.datagrid('getColumnOption', fields[i]);
      if(!fildOption.hidden) {
        $(`<div iconCls="${okCls}" field="${fields[i]}"/>`).html(fildOption.title).appendTo(tmenu);
      } else {
        $(`<div iconCls="${emptyCls}" field="${fields[i]}"/>`).html(fildOption.title).appendTo(tmenu);
      }
    }
    headerContextMenu = this.headerContextMenu = tmenu.menu({
      onClick: function(item) {
        let field = $(item.target).attr('field');
        if(item.iconCls === okCls) {
          grid.datagrid('hideColumn', field);
          $(this).menu('setIcon', {
            target: item.target,
            iconCls: emptyCls
          });
        } else {
          grid.datagrid('showColumn', field);
          $(this).menu('setIcon', {
            target: item.target,
            iconCls: okCls
          });
        }
      }
    });
  }
  headerContextMenu.menu('show', {
    left: e.pageX,
    top: e.pageY
  });
}

//客户端分页
//pagination:true
//loadFilter:pagerFilter
function pagerFilter(data) {
  if(typeof data.length == 'number' && typeof data.splice == 'function') {  // 判断数据是否是数组
    data = {
      total: data.length,
      rows: data
    };
  }
  let dg = $(this);
  let opts = dg.datagrid('options');
  let pager = dg.datagrid('getPager');
  pager.pagination({
    onSelectPage: function(pageNum, pageSize) {
      opts.pageNumber = pageNum;
      opts.pageSize = pageSize;
      pager.pagination('refresh', {
        pageNumber: pageNum,
        pageSize: pageSize
      });
      dg.datagrid('loadData', data);
    }
  });
  if(!data.originalRows) {
    data.originalRows = (data.rows);
  }
  let start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
  let end = start + parseInt(opts.pageSize);
  data.rows = (data.originalRows.slice(start, end));
  return data;
}

//滑框提示
function showMessage(title, msg, timeout) {
  $.messager.show({
    showType: 'slide',//显示效果：null,slide,fade,show
    title: title,//显示的标题
    msg: msg,//显示的消息
    timeout: timeout//超时关闭
  });
}

//页面加载动画
//页面未加载完毕之前显示loadingHtml内容
let loadingHtml = `
  <div id="loading"></div>
  <style>    
    .loading {
      width: 100%;
      height: 100%;
      position: absolute;
      left: 0;
      top: 0;
      right: 0;
      bottom: 0;
      margin: auto;;
      background-color: #fff;
      background-image: url('../img/loading.gif');
      background-size: 240px 180px;
      background-repeat: no-repeat;
      background-position: center;
      background-attachment: scroll;
  }
  </style>`;
document.write(loadingHtml);
//监听加载状态改变
document.onreadystatechange = completeLoading;

//加载完毕时移除loading效果
function completeLoading() {
  if(document.readyState === "complete") {
    $("#loading").remove();
  }
}

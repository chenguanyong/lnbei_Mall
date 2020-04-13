  /******************************************************
  林北科技出品
  简易表格操作函数
  作者：陈官勇
  日期：2020-03-01
  邮箱：993238441@qq.com
  *******************************************************
  */
  (function ($, fun){
  	if($ == undefined){
		throw "this is need jquery";
	}
	$.lb_table = fun();
  
  }($, function (){
  
  		var defaults = {
			id: "lnbei-table", //id
			height: $(window).height()-150,
			showHead:true,
			columns:{},//表头
			data:{},//表数据,
			tableClass:"table  table-bordered",
			trClass:"",
			isBody:false,
			url:"",
			sortName: "",
			sortOrder: "asc",
			pagination: true,
			pageSize: 10,
			currentPage:1,
			_isPagination:false,
			onCheckBoxClick:function (obj){//首部多选框单击事件
				
			},
			onRadioClick:function(obj){//首部单选框单击事件
				
			},
			paramfun:function (){
				if(obj.options.pagination){
					
					return {
					pageSize:obj.options.pageSize,
					currentPage:obj.options.currentPage,
					sortName:obj.options.sortName,
					sortOrder:obj.options.sortOrder
					}
				}
				else{
					return {
					sortName:obj.options.sortName,
					sortOrder:obj.options.sortOrder
				}
				}
			}
		};
  		window.onTableClick = function (obj){
  			
  		}
		var defaultcolumns = {
			height:"12",
			width:"60",
			checkbox:false,
			radiobox:false,
			field : '', 
			title : '',
			align : 'center',
			tdClass:"",
			c_x:[0],
			c_y:[0],
			r_x:[0],
			r_y:[0],
			filed_length:0,
			colspan:[0],
			rowspan:[0],
			formatter:function(row, value, index, rootId){
				return false;
			},
		};
		var obj = {
			options :{},
			init:function (options){
				obj.options = $.extend(defaults, options);
				//debugger;
				if(obj.options.url ==""){
					obj.initDraw(0,obj.options.data, obj.options.data.length);
				}else{
					obj.ajax(obj.options.url, obj.options.paramfun(), obj.initDraw);
				}
				
			},
			//分页
			pagination:function (dataSize, currentPage){
				var page = Math.ceil(dataSize / obj.options.pageSize);
				if(obj.options._isPagination){
					return "";
				}
				 myPageInit({
					pages: page,
					currentPage: currentPage,
					element: ".my-page",
					callback: function (page) {
						console.log("当前页:", page);
						obj.options.currentPage = page;
						if(page != 0){
							obj.refresh();
						}
					}
				});
			},
			initDraw:function (type, data ,dataSize){
			//debugger;
			var total = 0;
			var pageSize = obj.options.pageSize;
			var currentPage = obj.options.currentPage;
			var start = obj.options.pageSize * (obj.options.currentPage-1);
			var end = obj.options.pageSize * obj.options.currentPage;
			if(obj.options.pagination == false){
				if(type == 1){
					start = 0;
					end = data.length;
				}
			}
			
				//var data = obj.options.data;
				var tableHeard = "";//
				if(obj.options.showHead == true){
					tableHeard = obj.drawTrHeadElement("a");
				}
				var tableContent = "";
				if(obj.options.isBody == false){
					for (var i= start; i < end && i< data.length  ;i++){
						tableContent +=	obj.drawTrElement(data[i], i);
					}
					//tableContent += obj.
				}else{
				
					for (var i= start; i < end && i< data.length ;i++){
						var tempTableContent="";
						for(var a in data[i]){
							tempTableContent +=	obj.drawTrElement(data[i][a], a);
						}
						tableContent += obj.drawTbodyElement(tempTableContent, i);
					}
				
				}

				var tableHtml = obj.drawTableElement(tableHeard + tableContent);
				$("#" + obj.options.id).empty();
				$("#" + obj.options.id).html(tableHtml);
				if(obj.options.pagination == true){
					obj.pagination(dataSize,obj.options.currentPage);
				}
			},
			
			ajax:function (url, formData , callback, type){
						if(type == undefined){
							type="POST";
						}
			            $.ajax({
            				url: $.table._option.importUrl,
            				data: formData,
            				cache: false,
            				contentType: false,
            				processData: false,
            				type: type,
            				success: function (result) {
            					if(callback != undefined &&  typeof callback == "function"){
									if(result.code == 0){
										callback(1, result.data, result.count);
									}
								}
            				}
            			});
			
			
			},
			drawTableElement:function (tableBody){ // 绘画table元素
			
				return "<table class='"+obj.options.tableClass+"' id='" + obj.options.id+ "Table'>" + tableBody + "</table>";
			},
			drawThElement:function (column){//绘画TH元素
				var attrWidth = "width:"+column.width+";";
				var attrHeight = "height:" + column.height + ";";
				var attrAlign = "align-content:" + column.align + ";";
				var tdHtml = column.title;
				return "<td style='"+attrWidth+attrHeight+attrAlign+"'>" + tdHtml + "</td>";
			},
			drawTrBodysElement:function(row, index){
							
				var tempTableContent="";
				for(var a in row){
					tempTableContent +=	obj.drawTrElement(row[a], a);
				}
				return  obj.drawTbodyElement(tempTableContent, index);
					
			
			},
			drawTrElement:function(row, index){
				var trContent= "";
				trContent = obj.drawTrConent(row, index);
				var attr = obj.setAttrLB(0, index,"tr");
				return "<tr class='"+obj.options.trClass+"' "+ attr +">" + trContent + "</tr>";
			},
			
			drawTrConent:function(row, index){
				var y= index;
				var tableData = obj.options.data;
				var columns = obj.options.columns;
				var trContent= "";
				var length = columns.length;
				if(y >= (length-1) ){
					y = length-1;
				}
				for(var i in columns[y]){
					var value = "";

					var isCol = obj.checkCol(columns, i, index);
					var isRol = obj.checkRow(columns, i, index);
					var colspan = obj.getColspan(columns, i, index);
					var rowspan = 0;
					
					if(obj.options.isBody == false){
						rowspan=0;
						colspan=0;
						isCol = true;
						isRol =true;
						y = 0;
						rowspan = obj.getRolspan(columns, i, index, tableData.length);
					}else{
					//	var length = columns.length;
					//	if(y >= (length-1) ){
						//	y = length-1;
					//	}
						rowspan = obj.getRolspan(columns, i, index, tableData[0].length);
					}
					console.log("--" +y +"---" + "---" + i + "----" + "--------");
					
					console.log(columns[y][i].field);
					if(columns[y][i].field !='' && columns[y][i].checkbox != true && columns[y][i].radiobox != true ){
						eval("value=row."+columns[y][i].field+";");
					}
					//isCol = true;
					if(isCol && isRol){
						trContent += obj.drawTdElement(columns[y][i], row, value, index, colspan, rowspan );
					}
					
				}
				return trContent;
			},
			//检查行
			checkCol:function (colums, X, Y){
				var X = parseInt(X);
				var Y = parseInt(Y);			
				for(var i in colums){
					
					for(var x in colums[i]){
						var colum = colums[i][x];
						if(colum.c_x == undefined ||colum.c_y == undefined || colum.colspan == undefined ){
							continue; 
						}else{
							for(var a=0; a < colum.c_x.length; a ++ ){
								if(colum.c_x[a] != undefined && colum.c_x[a] != 0 && colum.colspan[a] != undefined){
									if((colum.c_y[a] ) == Y && colum.c_x[a] == X ){
									
										return true;
									
									}
									if(((colum.c_x[a] + colum.colspan[a]) >= (X) || colum.colspan[a] == -1 )&& colum.c_y == Y ){
									
										return true;
									
									}
								
								}
							}
						}
					}
				}
				return true;
			},	
			checkRow:function (colums, X, Y){
			var X = parseInt(X);
			var Y = parseInt(Y);
				for(var i in colums){
					
					for(var x in colums[i]) 
						{
							var colum = colums[i][x];
							//var r_x = 0;
							//var r_y = 0;&& colum.r_x[a] != 0
							if(colum.r_x == undefined ||colum.r_y == undefined || colum.rowspan == undefined ){
								continue;
							}else{
								for(var a=0; a < colum.r_x.length; a ++ ){
									if(colum.r_x[a] != undefined  && colum.rowspan[a] != undefined){
									var f= (colum.r_y[a] + colum.rowspan[a]) <= Y && colum.r_x[a] <= X ;
										if((colum.r_y[a] ) == Y && colum.r_x[a] == X ){
										
										return true;
										
										}
										if( ((colum.r_y[a] + colum.rowspan[a]) >= Y || colum.rowspan[a] == -1 ) && colum.r_x[a] == X ){
										
											return false;
										
										}
									
									}
								}
							}
						}
				}
				return true;
			},
			getColspan:function (colums, X, Y){
				var X = parseInt(X);
				var Y = parseInt(Y);
				for(var i in colums){
					for(var a in colums[i]){
						var colum = colums[i][a];
						if(colum.c_x == undefined ||colum.c_y == undefined || colum.colspan == undefined ){
							continue;
						}else{
							for(var a=0; a < colum.c_x.length; a ++ ){
								if(colum.c_x[a] != undefined  && colum.colspan[a] != undefined){
									if((colum.c_y[a] ) == Y && colum.c_x[a] == X ){
										if(colum.colspan[a] == -1){
											return colum.filed_length;
										}else{
										
											return colum.colspan[a];
										}
									}
									if((colum.c_y[a]) == Y ){
										//return colum.colspan[a];
									}
								}
							}
						}
					}
				}
				return 0;
			},
			getRolspan:function (colums, X, Y, dataLenth){
				var X = parseInt(X);
				var Y = parseInt(Y);
				for(var i in colums){
					for(var a in colums[i]){
						var colum = colums[i][a];
						//var colum = colums[i];
						if(colum.r_x == undefined ||colum.r_y == undefined || colum.rowspan == undefined ){
							continue;
						}else{
							for(var a=0; a < colum.r_x.length; a ++ ){
								if(colum.r_x[a] != undefined && colum.rowspan[a] != undefined){
									if((colum.r_y[a] ) == Y && colum.r_x[a] == X ){
										
										if( ( colum.rowspan[a] == -1 ) && colum.r_x[a] == X ){
											
											return dataLenth-parseInt(colum.r_y[a]);
										
										}else{
											return colum.rowspan[a];
										}
										
										
										
									}

									if( ((colum.r_y[a] + colum.rowspan[a]) >= Y || ( colum.rowspan[a] == -1 ) ) && colum.r_x[a] == X ){
										
										if(  colum.rowspan[a] == -1 ){
											
											return dataLenth-parseInt(colum.r_y[a]);
										
										}else{
										
										return colum.rowspan[a];
										}
									}
								
								}
							}
						}
					}
				}
				return 0;
			},
			//绘画表头元素
			drawTrHeadElement:function(index){
				var columns = obj.options.columns;
				var trContent= "";
				for(var i in columns){
					trContent += obj.drawThElement(columns[i]);
				}
				var attr = obj.setAttrLB(0, index,"tr");
				return "<tr "+ attr +">" + trContent + "</tr>";
			},//绘画TR元素			
			drawTdElement:function(column, row, value, index, colspan, rowspan ){//绘画Td元素
				var attrWidth = "width:"+column.width+";";
				var attrHeight = "height:" + column.height + ";";
				var attrAlign = "align-content:" + column.align + ";";
				var tdHtml = "";
				if(column.checkbox == true){
					tdHtml = obj.__checkboxHtml(value, index);
				}else if(column.radiobox == true){
					tdHtml = obj.__radioboxHtml(value, index);
				}else{
					//var column = $.extend(defaultcolumns, column);
					if(typeof(column.formatter) == 'function' ){
						tdHtml = column.formatter(row, value, index, obj.options.id);
						if(tdHtml == false){
							tdHtml = value;
						}
					
					}else {
						tdHtml = value;
					}
				
				}
				var attr = obj.setAttrLB(value, index, column.field);
				var tdClass = "";
				if(column.tdClass != undefined){
					tdClass = column.tdClass;
				}
				var colspanStr = "";
				if(colspan != 0){
					colspanStr = "colspan='" + colspan + "'";
				}
				var rowspanStr = "";
				if(rowspan != 0){
					rowspan ++;
					rowspanStr = "rowspan='" + rowspan + "'";
				}				
				return "<td "+ colspanStr + " " + rowspanStr +" class='"+tdClass+"' " + attr +" style='"+attrWidth+attrHeight+attrAlign+"'>" + tdHtml + "</td>";
			},//设置TD标签属性
			setAttrLB : function (value, index, field){
				return "lb-id='" +field + index + "' lb-value='" + value + "' lb-index='" + index + "'";
			},
			drawTheadElement:function(strContent){//绘画Thead元素
				return "<thead>" + strContent + "</thread>";
			},
			drawTbodyElement:function(strContent, index){//绘画Tbody元素
				return "<tbody lb-index='"+index+"' >" + strContent + "</tbody>";
			},
			drawTfootElement:function(strContent){//绘画Tfoot元素
				return "<tfoot>" + strContent + "</tfoot>";
			},
			__checkboxHtml:function (value, index){
				if(value == 1){
					return "<input onclick=\"onTableClick(this)\" lb-defined='sys' type='checkbox' lb-index='"+index+"' lb-id='checkbox" + index + "' "  + " checked='true' />";
				}else{
					return "<input onclick=\"onTableClick(this)\" lb-defined='sys' type='checkbox' lb-index='"+index+"' lb-id='checkbox" + index + "' "  + " />";
				}
				
			},
			__radioboxHtml:function (value, index){
				if(value == 1){
					return "<input onclick=\"onTableClick(this)\" lb-defined='sys' type='radio' lb-index='"+index+"' name='lb"+obj.options.id+"' lb-id='radiobox" + index + "' "  + " checked='true' />";
				}else{
					return "<input onclick=\"onTableClick(this)\" lb-defined='sys' type='radio' lb-index='"+index+"' name='lb"+obj.options.id+"' lb-id='radiobox" + index + "' "  + " />";
				}
				},//添加行
			addRow:function (data){
				var tableData = obj.options.data;
				if(data == undefined){
				
					throw new Error("data is not defined!!!");
				}
				tableData.push(data);
				if(obj.options.isBody == false){
				var trHtml = obj.drawTrElement(data, tableData.length-1);
				$("#"+ obj.options.id+"Table tbody").append(trHtml);
				}else{
				var trHtml = obj.drawTrBodysElement(data, tableData.length-1);
				$("#"+ obj.options.id+"Table ").append(trHtml);
				
				}
			},
			getData:function (){
				return obj.options.data;
			},
			getOptions:function(){
				return obj.options;
			},
			updataRow: function (index, data){
			//debugger;
			    var tableData = obj.options.data;
				if(index >= tableData.length ){
				
					throw new Error("Out of range");
				}
				var rowData = tableData[index];
				tableData[index] = $.extend(rowData, data);
				if(obj.options.isBody == false){
					var trContent = obj.drawTrConent(data, index);
					$("#"+ obj.options.id + " tr[lb-index="+index+"]").empty();
					$("#"+ obj.options.id + " tr[lb-index="+index+"]").html(trContent);
				}else{
					var trContent = obj.drawTrBodysElement(data, index);
					$("#"+ obj.options.id + " tbody[lb-index="+index+"]").empty();
					$("#"+ obj.options.id + " tbody[lb-index="+index+"]").html(trContent);
				
				}
			},
			getSelections:function (){
			  
			  var tableData = obj.options.data;
			  var selectionData = [];
		      var selectionIndex = obj.__getSelectionsIndex();
			  for(var i in selectionIndex){
				selectionData.push(tableData[selectionIndex[i]]);
			  }
			  return selectionData;
			},
			__getSelectionsIndex:function (){
			
			  var selection = $("#"+ obj.options.id + " input[lb-defined=sys]:checked");
			  var selectionIndex = [];
			  selection.each(function (){
			  
			  var index = $(this).attr('lb-index');
			    selectionIndex.push(index);
			  });
			  return selectionIndex;
			},
			remove:function (index){
			
				var selectionIndex="";
				if(index != undefined){
					selectionIndex = [index];
				}else {
					
					selectionIndex = obj.__getSelectionsIndex();
				}
				var tableData = obj.options.data;
				var temp = [];
				for(var i in tableData){
					if(selectionIndex.indexOf(i) == -1){
					
						temp.push(tableData[i]);
					}
				
				}
				obj.options.data = temp;
				for(var i in selectionIndex){
					if(obj.options.isBody == false){
						$("#"+ obj.options.id + " tr[lb-index="+selectionIndex[i]+"]").detach();
					}else{
						$("#"+ obj.options.id + " tbody[lb-index="+selectionIndex[i]+"]").detach();
					}
				}
				obj.refresh();
			},
			refresh:function (){
			    $("#"+ obj.options.id).empty();
				obj.options._isPagination = true;
				obj.init();
			}
			
		};
  
		return obj;
  
  }));
  function myPageInit({
	    pages = 10,
	    currentPage = 1,
	    element = '.my-page',
	    callback
	}) {

	    intercept();

	    const myPageEl = document.querySelector(element);

	    // 构造结构
	    let htmlStrArr = [];
	    for (let i = 0; i < pages; i++) {
	        htmlStrArr.push(`<li class="my-page-cell">${i + 1}</li>`);
	    };
	    if (pages > 7) {
	        htmlStrArr.splice(5, htmlStrArr.length - 6, "<li class='my-page-omit'>...</li>");
	    };
	    htmlStr = htmlStrArr.join("");
	    let pageHtmlStr = `<div class="my-page-prev"><</div>
	        <ul class="my-page-group">${htmlStr}</ul>
	        <div class="my-page-next">></div>`;

	    // 注入结构
	    myPageEl.innerHTML = pageHtmlStr;

	    // 标记默认页
	    clickPageFun(currentPage);

	    // 上下页切换事件注册
	    let btns = document.querySelectorAll(`${element} div`);
	    btns.forEach(el => {
	        el.onclick = switchPage;
	    });

	    // 点击事件注册
	    myPageEl.onclick = function (e) {
	        // console.log(e)
	        let classNameArr = e.target.className.split(" ");
	        if (classNameArr.indexOf("my-page-cell") !== -1) {
	            clickPageFun(Number(e.target.innerText));
	        };
	    }

	    // 上下页按钮触发
	    function switchPage(e) {
	        // 获取当前页
	        let page = document.querySelector(`${element} .my-page-checked`).innerText - 0;

	        let classNameArr = e.target.className.split(" ");
	        if (classNameArr.indexOf("my-page-prev") !== -1) {
	            clickPageFun(page - 1); // 上一页
	        } else if (classNameArr.indexOf("my-page-next") !== -1) {
	            clickPageFun(page + 1); // 下一页
	        };
	    };


	    // 分页切换处理
	    function clickPageFun(page) {
	        page = Number(page);
	        // 满足条件改变结构
	        if (pages > 7) {
	            let newEl = '';
	            if (page <= 4) {
	                newEl = `
	                <li class="my-page-cell">1</li>
	                <li class="my-page-cell">2</li>
	                <li class="my-page-cell">3</li>
	                <li class="my-page-cell">4</li>
	                <li class="my-page-cell">5</li>
	                <li class="my-page-omit">...</li>
	                <li class="my-page-cell">${pages}</li>`;
	            } else if (page >= 5 && page < pages - 3) {
	                newEl = `
	                <li class="my-page-cell">1</li>
	                <li class="my-page-omit">...</li>
	                <li class="my-page-cell">${page - 1}</li>
	                <li class="my-page-cell">${page}</li>
	                <li class="my-page-cell">${page + 1}</li>
	                <li class="my-page-omit">...</li>
	                <li class="my-page-cell">${pages}</li>`;
	            } else if (page >= pages - 3) {
	                newEl = `
	                <li class="my-page-cell">1</li>
	                <li class="my-page-omit">...</li>
	                <li class="my-page-cell">${pages - 4}</li>
	                <li class="my-page-cell">${pages - 3}</li>
	                <li class="my-page-cell">${pages - 2}</li>
	                <li class="my-page-cell">${pages - 1}</li>
	                <li class="my-page-cell">${pages}</li>`;
	            };
	            document.querySelector(`${element} .my-page-group`).innerHTML = newEl;
	        };

	        // 标注选中项
	        let pageCellELs = document.querySelectorAll(`${element} .my-page-cell`);
	        pageCellELs.forEach(el => {
	            if (el.innerText == page) {
	                el.classList.add('my-page-checked');
	            } else {
	                el.classList.remove('my-page-checked');
	            };
	        });

	        forbidden(page);

	        // 回调响应
	        callback && callback(page);
	    };

	    // 上下页按钮启禁
	    function forbidden(page) {
	        let prveEl = document.querySelector(`${element} .my-page-prev`);
	        let nextEl = document.querySelector(`${element} .my-page-next`);
	        if (page === 1) {
	            prveEl.classList.add('my-page-forbid');
	        } else {
	            prveEl.classList.remove('my-page-forbid');
	        };

	        if (page === pages) {
	            nextEl.classList.add('my-page-forbid');
	        } else {
	            nextEl.classList.remove('my-page-forbid');
	        };
	    };

	    // 参数检验
	    function intercept() {
	        if (!pages || pages === 0 || (Math.floor(pages) != pages)) {
	            throw "my-page中pages必须是整数且不为0";
	            pages = Math.floor(pages);
	        };

	        if (!currentPage || currentPage === 0 || (Math.floor(currentPage) !== currentPage)) {
	            throw "my-page中currentPage必须是整数且不为0";
	            currentPage = Math.floor(currentPage);

	        };

	        if (document.querySelectorAll(element).length === 0) {
	            throw element + "元素不存在";
	        };

	        if (currentPage > pages) {
	            throw "当前页不存在";
	        }
	    };
	}
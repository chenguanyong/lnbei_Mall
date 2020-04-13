/**
 * 通用js方法封装处理
 * Copyright (c) 2019 lnbei
 */
(function ($) {
    $.extend({
    	_treeTable: {},
    	_tree: {},
    	// 表格封装处理
    	table: {
            _option: {},
            // 初始化表格参数
            init: function(options) {
            	var defaults = {
            		id: "bootstrap-table",
            		type: 0, // 0 代表bootstrapTable 1代表bootstrapTreeTable
        		    height: $(window).height()-150,
        		    sidePagination: "server",
        		    sortName: "",
        		    sortOrder: "asc",
        		    pagination: true,
        		    pageSize: 10,
        		    toolbar: "toolbar",
        		    striped: false,
        		    escape: false,
        		    showFooter: false,
        		    search: false,
                    showSearch: false,
                    showPageGo: false,
                    showRefresh: true,
                    showColumns: false,
                    showToggle: false,
                    showExport: false,
        		    fixedColumns: false,
        		    fixedNumber: 0,
        		    rightFixedColumns: false,
        		    rightFixedNumber: 0,
        		    queryParams: $.table.queryParams,
        		};
            	var options = $.extend(defaults, options);
                $.table._option = options;
                $('#' + options.id).bootstrapTable({
                    url: options.url,                                   // 请求后台的URL（*）
                    contentType: "application/x-www-form-urlencoded",   // 编码类型
                    method: 'post',                                     // 请求方式（*）
                    cache: false,                                       // 是否使用缓存
                    height: options.height,                             // 表格的高度
                    striped: options.striped,                           // 是否显示行间隔色
                    sortable: true,                                     // 是否启用排序
                    sortStable: true,                                   // 设置为 true 将获得稳定的排序
                    sortName: options.sortName,                         // 排序列名称
                    sortOrder: options.sortOrder,                       // 排序方式  asc 或者 desc
                    pagination: options.pagination,                     // 是否显示分页（*）
                    pageNumber: 1,                                      // 初始化加载第一页，默认第一页
                    pageSize: options.pageSize,                         // 每页的记录行数（*） 
                    pageList: [10, 25, 50],                             // 可供选择的每页的行数（*）
                    escape: options.escape,                             // 转义HTML字符串
                    showFooter: options.showFooter,                     // 是否显示表尾
                    iconSize: 'outline',                                // 图标大小：undefined默认的按钮尺寸 xs超小按钮sm小按钮lg大按钮
                    toolbar: '#' + options.toolbar,                     // 指定工作栏
                    sidePagination: options.sidePagination,             // server启用服务端分页client客户端分页
                    search: options.search,                             // 是否显示搜索框功能
                    showSearch: options.showSearch,                     // 是否显示检索信息
                    showPageGo: options.showPageGo,               		// 是否显示跳转页
                    showRefresh: options.showRefresh,                   // 是否显示刷新按钮
                    showColumns: options.showColumns,                   // 是否显示隐藏某列下拉框
                    showToggle: options.showToggle,                     // 是否显示详细视图和列表视图的切换按钮
                    showExport: options.showExport,                     // 是否支持导出文件
                    fixedColumns: options.fixedColumns,                 // 是否启用冻结列（左侧）
                    fixedNumber: options.fixedNumber,                   // 列冻结的个数（左侧）
                    rightFixedColumns: options.rightFixedColumns,       // 是否启用冻结列（右侧）
                    rightFixedNumber: options.rightFixedNumber,         // 列冻结的个数（右侧）
                    queryParams: options.queryParams,                   // 传递参数（*）
                    columns: options.columns,                           // 显示列信息（*）
                    responseHandler: $.table.responseHandler,           // 在加载服务器发送来的数据之前处理函数
                    onLoadSuccess: $.table.onLoadSuccess,               // 当所有数据被加载时触发处理函数
                });
            },
            // 查询条件
            queryParams: function(params) {
            	return {
        			// 传递参数查询参数
                    pageSize:       params.limit,
                    pageNum:        params.offset / params.limit + 1,
                    searchValue:    params.search,
                    orderByColumn:  params.sort,
                    isAsc:          params.order
        		}; 
            },
            // 请求获取数据后处理回调函数
            responseHandler: function(res) {
                if (res.code == 0) {
                    if ($.common.isNotEmpty($.table._option.sidePagination) && $.table._option.sidePagination == 'client') {
                    	return res.rows;
                    } else {
                        return { rows: res.rows, total: res.total };
                    }
                } else {
                    $.modal.alertWarning(res.msg);
                    return { rows: [], total: 0 };
                }
            },
            // 当所有数据被加载时触发
            onLoadSuccess: function(data) {
            	// 浮动提示框特效
            	$("[data-toggle='tooltip']").tooltip();
            	// 触发行点击事件
            	$("#" + $.table._option.id).on("check.bs.table uncheck.bs.table check-all.bs.table uncheck-all.bs.table load-success.bs.table", function () {
            		var ids = $("#" + $.table._option.id).bootstrapTable("getSelections");
            		$('#' + $.table._option.toolbar + ' .btn-del').toggleClass('disabled', !ids.length);
            		$('#' + $.table._option.toolbar + ' .btn-edit').toggleClass('disabled', ids.length!=1);
            	});
            },
            // 表格销毁
            destroy: function (tableId) {
            	var currentId = $.common.isEmpty(tableId) ? $.table._option.id : tableId;
            	$("#" + currentId).bootstrapTable('destroy');
	        },
            // 序列号生成
            serialNumber: function (index) {
				var table = $('#' + $.table._option.id).bootstrapTable('getOptions');
				var pageSize = table.pageSize;
				var pageNumber = table.pageNumber;
				return pageSize * (pageNumber - 1) + index + 1;
			},
			// 列超出指定长度浮动提示
			tooltip: function (value, length) {
				var _length = $.common.isEmpty(length) ? 20 : length;
				var _text = "";
				var _value = $.common.nullToStr(value);
				if (_value.length > _length) {
					_text = _value.substr(0, _length) + "...";
				} else {
					_text = _value;
				}
				return '<a href="#" class="tooltip-show" data-toggle="tooltip" title="' + _value + '">' + _text +'</a>';
			},
			// 下拉按钮切换
			dropdownToggle: function (value) {
				var actions = [];
				actions.push('<div class="btn-group">');
				actions.push('<button type="button" class="btn btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false">');
				actions.push('<i class="fa fa-cog"></i>&nbsp;<span class="fa fa-chevron-down"></span></button>');
				actions.push('<ul class="dropdown-menu">');
				actions.push(value.replace(/<a/g,"<li><a").replace(/<\/a>/g,"</a></li>"));
				actions.push('</ul>');
				actions.push('</div>');
				return actions.join('');
			},
            // 搜索-默认第一个form
            search: function(formId) {
            	var currentId = $.common.isEmpty(formId) ? $('form').attr('id') : formId;
    		    var params = $("#" + $.table._option.id).bootstrapTable('getOptions');
    		    params.queryParams = function(params) {
                    var search = {};
                    $.each($("#" + currentId).serializeArray(), function(i, field) {
                        search[field.name] = field.value;
                    });
                    
                    search.pageSize = params.limit;
                    search.pageNum = params.offset / params.limit + 1;
                    search.searchValue = params.search;
                    search.orderByColumn = params.sort;
                    search.isAsc = params.order;
    		        return search;
    		    }
    		    
    		    $("#" + $.table._option.id).bootstrapTable('refresh', params);
    		},
    		// 导出数据
    		exportExcel: function(formId) {
    			var currentId = $.common.isEmpty(formId) ? $('form').attr('id') : formId;
    			$.modal.loading("正在导出数据，请稍后...");
    			$.post($.table._option.exportUrl, $("#" + currentId).serializeArray(), function(result) {
    				if (result.code == web_status.SUCCESS) {
    			        window.location.href = ctx + "common/download?fileName=" + result.msg + "&delete=" + true;
    				} else {
    					$.modal.alertError(result.msg);
    				}
    				$.modal.closeLoading();
    			});
    		},
    		// 下载模板
    		importTemplate: function() {
    			$.get($.table._option.importTemplateUrl, function(result) {
    				if (result.code == web_status.SUCCESS) {
    			        window.location.href = ctx + "common/download?fileName=" + result.msg + "&delete=" + true;
    				} else {
    					$.modal.alertError(result.msg);
    				}
    			});
            },
            // 导入数据
            importExcel: function(formId) {
            	var currentId = $.common.isEmpty(formId) ? 'importForm' : formId;
            	$.form.reset(currentId);
            	layer.open({
            		type: 1,
            		area: ['400px', '230px'],
            		fix: false,
            		//不固定
            		maxmin: true,
            		shade: 0.3,
            		title: '导入' + $.table._option.modalName + '数据',
            		content: $('#' + currentId),
            		btn: ['<i class="fa fa-check"></i> 导入', '<i class="fa fa-remove"></i> 取消'],
            		// 弹层外区域关闭
            		shadeClose: true,
            		btn1: function(index, layero){
            			var file = layero.find('#file').val();
            			if (file == '' || (!$.common.endWith(file, '.xls') && !$.common.endWith(file, '.xlsx'))){
            				$.modal.msgWarning("请选择后缀为 “xls”或“xlsx”的文件。");
            				return false;
            			}
            			var index = layer.load(2, {shade: false});
            			$.modal.disable();
            			var formData = new FormData();
            			formData.append("file", $('#file')[0].files[0]);
            			formData.append("updateSupport", $("input[name='updateSupport']").is(':checked'));
            			$.ajax({
            				url: $.table._option.importUrl,
            				data: formData,
            				cache: false,
            				contentType: false,
            				processData: false,
            				type: 'POST',
            				success: function (result) {
            					if (result.code == web_status.SUCCESS) {
            						$.modal.closeAll();
            						$.modal.alertSuccess(result.msg);
            						$.table.refresh();
            					} else {
            						layer.close(index);
            						$.modal.enable();
            						$.modal.alertError(result.msg);
            					}
            				}
            			});
            		}
            	});
            },
            // 刷新表格
            refresh: function() {
                $("#" + $.table._option.id).bootstrapTable('refresh', {
                    silent: true
                });
            },
            getIdSelections: function () {
    		    return $.map($("#" + $.table._option.id).bootstrapTable('getSelections'), function (row) {
    		        return row.mid;
    		    });
    		},
            // 查询表格指定列值
            selectColumns: function(column) {
            	return $.map($('#' + $.table._option.id).bootstrapTable('getSelections'), function (row) {
        	        return row[column];
        	    });
            },
            // 查询表格首列值
            selectFirstColumns: function() {
            	return $.map($('#' + $.table._option.id).bootstrapTable('getSelections'), function (row) {
        	        return row[$.table._option.columns[1].field];
        	    });
            },
            // 回显数据字典
            selectDictLabel: function(datas, value) {
            	var actions = [];
                $.each(datas, function(index, dict) {
                    if (dict.dictValue == ('' + value)) {
                    	actions.push("<span class='badge badge-" + dict.listClass + "'>" + dict.dictLabel + "</span>");
                        return false;
                    }
                });
                return actions.join('');
            },
            // 显示表格指定列
            showColumn: function(column) {
                $("#" + $.table._option.id).bootstrapTable('showColumn', column);
            },
            // 隐藏表格指定列
            hideColumn: function(column) {
            	$("#" + $.table._option.id).bootstrapTable('hideColumn', column);
            }
        },
        
        usertree:function (type){
            	var url = ctx + "system/user/userTree?type="+type;
    			var options = {
    				title: '用户列表',
    				url: url,
    				callBack: function (index, layero){
    	            	var rationWindow = layero.find("iframe")[0].contentWindow;
    	    			var treeData = rationWindow.submitHandler(index, window);
    	    			
    	    			$("#userIds").val(treeData.userIds);
    	    			$("#userNames").val(treeData.userName);
    	            }
    			};
    			$.modal.openOptions(options);
        },
        categorytree:function (flag){
        	selectCategoryTree(flag);
            function selectCategoryTree(flag) {

            	var url = ctx + "home/homeCategory/categoryTree?flag=" + flag;
    			var options = {
    				title: '选择类别',
    				width: "380",
    				url: url,
    				callBack: doSubmit
    			};
    			$.modal.openOptions(options);
    		}
    		
    		function doSubmit(index, layero){
    			var tree = layero.find("iframe")[0].contentWindow.$._tree;
    		
    				var body = layer.getChildFrame('body', index);
        			$("#classifyId").val(body.find('#treeId').val());
        			$("#classify").val(body.find('#treeName').val());
        			layer.close(index);
    		}
        	
        },
        
        // 表格树封装处理
        treeTable: {
            // 初始化表格
            init: function(options) {
            	var defaults = {
            		id: "bootstrap-tree-table",
                    type: 1, // 0 代表bootstrapTable 1代表bootstrapTreeTable
        		    height: 0,
        		    ajaxParams: {},
        		    toolbar: "toolbar",
        		    striped: false,
        		    expandColumn: 1,
        		    showRefresh: true,
        			showColumns: true,
        			expandAll: true,
        			expandFirst: true
        		};
            	var options = $.extend(defaults, options);
                $.table._option = options;
                var treeTable = $('#' + options.id).bootstrapTreeTable({
                	code: options.code,                                 // 用于设置父子关系
        		    parentCode: options.parentCode,                     // 用于设置父子关系
        	    	type: 'get',                                        // 请求方式（*）
        	        url: options.url,                                   // 请求后台的URL（*）
        	        ajaxParams: options.ajaxParams,                     // 请求数据的ajax的data属性
        	        height: options.height,                             // 表格树的高度
        			expandColumn: options.expandColumn,                 // 在哪一列上面显示展开按钮
        			striped: options.striped,                           // 是否显示行间隔色
        			bordered: true,                                     // 是否显示边框
        			toolbar: '#' + options.toolbar,                     // 指定工作栏
        			showRefresh: options.showRefresh,                   // 是否显示刷新按钮
        			showColumns: options.showColumns,                   // 是否显示隐藏某列下拉框
        			expandAll: options.expandAll,                       // 是否全部展开
        			expandFirst: options.expandFirst,                   // 是否默认第一级展开--expandAll为false时生效
        	        columns: options.columns
        	    });
                $._treeTable = treeTable;
            },	

            // 条件查询
            search: function(formId) {
            	var currentId = $.common.isEmpty(formId) ? $('form').attr('id') : formId;
            	var params = {};
            	$.each($("#" + currentId).serializeArray(), function(i, field) {
            		params[field.name] = field.value;
		        });
            	$._treeTable.bootstrapTreeTable('refresh', params);
            },
            // 刷新
            refresh: function() {
            	$._treeTable.bootstrapTreeTable('refresh');
            },
        },
        // 表单封装处理
    	form: {
    		// 表单重置
    		reset: function(formId) {
            	var currentId = $.common.isEmpty(formId) ? $('form').attr('id') : formId;
            	$("#" + currentId)[0].reset();
            },
            // 获取选中复选框项
            selectCheckeds: function(name) {
            	var checkeds = "";
        	    $('input:checkbox[name="' + name + '"]:checked').each(function(i) {
        	        if (0 == i) {
        	        	checkeds = $(this).val();
        	        } else {
        	        	checkeds += ("," + $(this).val());
        	        }
        	    });
        	    return checkeds;
            },
            // 获取选中下拉框项
            selectSelects: function(name) {
            	var selects = "";
        	    $('#' + name + ' option:selected').each(function (i) {
        	        if (0 == i) {
        	        	selects = $(this).val();
        	        } else {
        	        	selects += ("," + $(this).val());
        	        }
        	    });
        	    return selects;
            }
        },
        // 弹出层封装处理
    	modal: {
    		// 显示图标
    		icon: function(type) {
            	var icon = "";
        	    if (type == modal_status.WARNING) {
        	        icon = 0;
        	    } else if (type == modal_status.SUCCESS) {
        	        icon = 1;
        	    } else if (type == modal_status.FAIL) {
        	        icon = 2;
        	    } else {
        	        icon = 3;
        	    }
        	    return icon;
            },
    		// 消息提示
            msg: function(content, type) {
            	if (type != undefined) {
                    layer.msg(content, { icon: $.modal.icon(type), time: 1000, shift: 5 });
                } else {
                    layer.msg(content);
                }
            },
            // 错误消息
            msgError: function(content) {
            	$.modal.msg(content, modal_status.FAIL);
            },
            // 成功消息
            msgSuccess: function(content) {
            	$.modal.msg(content, modal_status.SUCCESS);
            },
            // 警告消息
            msgWarning: function(content) {
            	$.modal.msg(content, modal_status.WARNING);
            },
    		// 弹出提示
            alert: function(content, type) {
        	    layer.alert(content, {
        	        icon: $.modal.icon(type),
        	        title: "系统提示",
        	        btn: ['确认'],
        	        btnclass: ['btn btn-primary'],
        	    });
            },
            // 消息提示并刷新父窗体
            msgReload: function(msg, type) {
            	layer.msg(msg, {
            	    icon: $.modal.icon(type),
            	    time: 500,
            	    shade: [0.1, '#8F8F8F']
            	},
            	function() {
            	    $.modal.reload();
            	});
            },
            // 错误提示
            alertError: function(content) {
            	$.modal.alert(content, modal_status.FAIL);
            },
            // 成功提示
            alertSuccess: function(content) {
            	$.modal.alert(content, modal_status.SUCCESS);
            },
            // 警告提示
            alertWarning: function(content) {
            	$.modal.alert(content, modal_status.WARNING);
            },
            // 关闭窗体
            close: function () {
            	var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
            },
            // 关闭全部窗体
            closeAll: function () {
                layer.closeAll();
            },
            // 确认窗体
            confirm: function (content, callBack) {
            	layer.confirm(content, {
        	        icon: 3,
        	        title: "系统提示",
        	        btn: ['确认', '取消'],
        	        btnclass: ['btn btn-primary', 'btn btn-danger'],
        	    }, function (index) {
        	    	layer.close(index);
        	        callBack(true);
        	    });
            },
            // 弹出层指定宽度
            open: function (title, url, width, height, callback) {
            	//如果是移动端，就使用自适应大小弹窗
            	if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
            	    width = 'auto';
            	    height = 'auto';
            	}
            	if ($.common.isEmpty(title)) {
                    title = false;
                };
                if ($.common.isEmpty(url)) {
                    url = "/404.html";
                };
                if ($.common.isEmpty(width)) {
                	width = 800;
                };
                if ($.common.isEmpty(height)) {
                	height = ($(window).height() - 50);
                };
                if ($.common.isEmpty(callback)) {
                    callback = function(index, layero) {
                        var iframeWin = layero.find('iframe')[0];
                        iframeWin.contentWindow.submitHandler();
                    }
                }
            	layer.open({
            		type: 2,
            		area: [width + 'px', height + 'px'],
            		fix: false,
            		//不固定
            		maxmin: true,
            		shade: 0.3,
            		title: title,
            		content: url,
            		btn: ['确定', '关闭'],
            	    // 弹层外区域关闭
            		shadeClose: true,
            		yes: callback,
            	    cancel: function(index) {
            	        return true;
            	    }
            	});
            },
            // 弹出层指定宽度
            openFun: function (title, url, width, height, callback,fun,id) {
            	//如果是移动端，就使用自适应大小弹窗
            	if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
            	    width = 'auto';
            	    height = 'auto';
            	}
            	if ($.common.isEmpty(title)) {
                    title = false;
                };
                if ($.common.isEmpty(url)) {
                    url = "/404.html";
                };
                if ($.common.isEmpty(width)) {
                	width = 800;
                };
                if ($.common.isEmpty(height)) {
                	height = ($(window).height() - 50);
                };
        		if( typeof fun === "function"){
    				//var row = $.table.selectNowRow();
    				var bFlag = fun(id);
    				if(!bFlag) {
    					return false;
    				}
    			}
                if ($.common.isEmpty(callback)) {
                    callback = function(index, layero) {
                  
                        var iframeWin = layero.find('iframe')[0];
                        iframeWin.contentWindow.submitHandler();
                    }
                }
            	layer.open({
            		type: 2,
            		area: [width + 'px', height + 'px'],
            		fix: false,
            		//不固定
            		maxmin: true,
            		shade: 0.3,
            		title: title,
            		content: url,
            		btn: ['确定', '关闭'],
            	    // 弹层外区域关闭
            		shadeClose: true,
            		yes: callback,
            	    cancel: function(index) {
            	        return true;
            	    }
            	});
            },
            // 弹出层指定参数选项
            openOptions: function (options) {
            	var _url = $.common.isEmpty(options.url) ? "/404.html" : options.url; 
            	var _title = $.common.isEmpty(options.title) ? "系统窗口" : options.title; 
                var _width = $.common.isEmpty(options.width) ? "800" : options.width; 
                var _height = $.common.isEmpty(options.height) ? ($(window).height() - 50) : options.height;
                layer.open({
                    type: 2,
            		maxmin: true,
                    shade: 0.3,
                    title: _title,
                    fix: false,
                    area: [_width + 'px', _height + 'px'],
                    content: _url,
                    shadeClose: true,
                    btn: ['<i class="fa fa-check"></i> 确认', '<i class="fa fa-close"></i> 关闭'],
                    yes: function (index, layero) {
                        options.callBack(index, layero)
                    }, cancel: function () {
                        return true;
                    }
                });
            },
            openPrintFullOptions: function (options) {
            	var _url = $.common.isEmpty(options.url) ? "/404.html" : options.url; 
            	var _title = $.common.isEmpty(options.title) ? "系统窗口" : options.title; 
                var _width = $.common.isEmpty(options.width) ? "800" : options.width; 
                var _height = $.common.isEmpty(options.height) ? ($(window).height() - 50) : options.height;
	              var index = layer.open({
	                    type: 2,
	            		maxmin: true,
	                    shade: 0.3,
	                    title: _title,
	                    fix: false,
	                    area: [_width + 'px', _height + 'px'],
	                    content: _url,
	                    shadeClose: true,
	                    btn: ['<i class="fa fa-check"></i> 打印', '<i class="fa fa-close"></i> 关闭'],
	                    yes: function (index, layero) {
	                        options.callBack(index, layero)
	                    }, cancel: function () {
	                        return true;
	                    }
	                });
	              layer.full(index);
            },
            // 弹出层全屏
            openFull: function (title, url, width, height) {
            	//如果是移动端，就使用自适应大小弹窗
            	if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
            	    width = 'auto';
            	    height = 'auto';
            	}
            	if ($.common.isEmpty(title)) {
                    title = false;
                };
                if ($.common.isEmpty(url)) {
                    url = "/404.html";
                };
                if ($.common.isEmpty(width)) {
                	width = 800;
                };
                if ($.common.isEmpty(height)) {
                	height = ($(window).height() - 50);
                };
                var index = layer.open({
            		type: 2,
            		area: [width + 'px', height + 'px'],
            		fix: false,
            		//不固定
            		maxmin: true,
            		shade: 0.3,
            		title: title,
            		content: url,
            		btn: ['确定', '关闭'],
            		// 弹层外区域关闭
            		shadeClose: true,
            		yes: function(index, layero) {
            	        var iframeWin = layero.find('iframe')[0];
            	        iframeWin.contentWindow.submitHandler();
            	    },
            	    cancel: function(index) {
            	        return true;
            	    }
            	});
                layer.full(index);
            },
            // 弹出层全屏
            openFullOptions: function (options) {
            	//如果是移动端，就使用自适应大小弹窗
            	var _url = $.common.isEmpty(options.url) ? "/404.html" : options.url; 
            	var _title = $.common.isEmpty(options.title) ? "系统窗口" : options.title; 
                var _width = $.common.isEmpty(options.width) ? "800" : options.width; 
                var _height = $.common.isEmpty(options.height) ? ($(window).height() - 50) : options.height;
                var index = layer.open({
            		type: 2,
            		area: [_width + 'px', _height + 'px'],
            		fix: false,
            		//不固定
            		maxmin: true,
            		shade: 0.3,
            		title: _title,
            		content: _url,
            		btn: ['确定', '关闭'],
            		// 弹层外区域关闭
            		shadeClose: true,
            		yes: function(index, layero) {
            	        options.callBack(index, layero)
            	    },
            	    cancel: function(index) {
            	        return true;
            	    }
            	});
                layer.full(index);
            },
            // 弹出层全屏
            openFullView: function (title, url, width, height) {
            	//如果是移动端，就使用自适应大小弹窗
            	if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
            	    width = 'auto';
            	    height = 'auto';
            	}
            	if ($.common.isEmpty(title)) {
                    title = false;
                };
                if ($.common.isEmpty(url)) {
                    url = "/404.html";
                };
                if ($.common.isEmpty(width)) {
                	width = 800;
                };
                if ($.common.isEmpty(height)) {
                	height = ($(window).height() - 50);
                };
                var index = layer.open({
            		type: 2,
            		area: [width + 'px', height + 'px'],
            		fix: false,
            		//不固定
            		maxmin: true,
            		shade: 0.3,
            		title: title,
            		content: url,
            		
            		// 弹层外区域关闭
            		shadeClose: true,
            	  
            	});
                layer.full(index);
            },
            // 弹出层全屏
            openView: function (title, url, width, height) {
            	//如果是移动端，就使用自适应大小弹窗
            	if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
            	    width = 'auto';
            	    height = 'auto';
            	}
            	if ($.common.isEmpty(title)) {
                    title = false;
                };
                if ($.common.isEmpty(url)) {
                    url = "/404.html";
                };
                if ($.common.isEmpty(width)) {
                	width = 500;
                };
                if ($.common.isEmpty(height)) {
                	height = ($(window).height() - 50);
                };
                var index = layer.open({
            		type: 2,
            		area: [width + 'px', height + 'px'],
            		fix: false,
            		//不固定
            		maxmin: true,
            		shade: 0.3,
            		title: title,
            		content: url,
            		// 弹层外区域关闭
            		shadeClose: true,
            	});
               // layer.full(index);
            },            
            // 选卡页方式打开
            openTab: function (title, url) {
            	createMenuItem(url, title);
            },
            // 禁用按钮
            disable: function() {
            	var doc = window.top == window.parent ? window.document : window.parent.document;
	        	$("a[class*=layui-layer-btn]", doc).addClass("layer-disabled");
            },
            // 启用按钮
            enable: function() {
            	var doc = window.top == window.parent ? window.document : window.parent.document;
            	$("a[class*=layui-layer-btn]", doc).removeClass("layer-disabled");
            },
            // 打开遮罩层
            loading: function (message) {
            	$.blockUI({ message: '<div class="loaderbox"><div class="loading-activity"></div> ' + message + '</div>' });
            },
            // 关闭遮罩层
            closeLoading: function () {
            	setTimeout(function(){
            		$.unblockUI();
            	}, 50);
            },
            // 重新加载
            reload: function () {
            	parent.location.reload();
            }
        },
        // 操作封装处理
        operate: {
        	ajaxByFormData:function (url, data, type){
        		
        		if(type == undefined || type == ""){
        			type= "post";
        		}
	        	var formData = new FormData();
	        	for(var i in data){
	        		formData.append(i, data[i]);
	        	}
	        	$.ajax({
	        		url: url,
	        		type: type,
	        		cache: false,
	        		data: formData,
	        		processData: false,
	        		contentType: false,
	        		dataType: "json",
	        		success: function(result) {
	        			$.operate.successCallback(result);
	        		}
	        	});
        	},
        	// 提交数据
        	submit: function(url, type, dataType, data) {
            	var config = {
        	        url: url,
        	        type: type,
        	        dataType: dataType,
        	        data: data,
        	        beforeSend: function () {
        	        	$.modal.loading("正在处理中，请稍后...");
        	        },
        	        success: function(result) {
        	        	$.operate.ajaxSuccess(result);
        	        }
        	    };
        	    $.ajax(config)
            },
            // post请求传输
            post: function(url, data) {
            	$.operate.submit(url, "post", "json", data);
            },
            // get请求传输
            get: function(url) {
            	$.operate.submit(url, "get", "json", "");
            },
            // 详细信息
            detail: function(id, width, height) {
            	var _url = $.common.isEmpty(id) ? $.table._option.detailUrl : $.table._option.detailUrl.replace("{id}", id);
                var _width = $.common.isEmpty(width) ? "800" : width; 
                var _height = $.common.isEmpty(height) ? ($(window).height() - 50) : height;
            	//如果是移动端，就使用自适应大小弹窗
            	if (navigator.userAgent.match(/(iPhone|iPod|Android|ios)/i)) {
            	    _width = 'auto';
            	    _height = 'auto';
            	}
            	layer.open({
            		type: 2,
            		area: [_width + 'px', _height + 'px'],
            		fix: false,
            		//不固定
            		maxmin: true,
            		shade: 0.3,
            		title: $.table._option.modalName + "详细",
            		content: _url,
            		btn: ['关闭'],
            	    // 弹层外区域关闭
            		shadeClose: true,
            		cancel: function(index){
            			return true;
         	        }
            	});
            },
            // 删除信息
            remove: function(id) {
            	$.modal.confirm("确定删除该条" + $.table._option.modalName + "信息吗？", function() {
                    var url = $.common.isEmpty(id) ? $.table._option.removeUrl : $.table._option.removeUrl.replace("{id}", id);
                    if($.table._option.type == table_type.bootstrapTreeTable) {
                    	$.operate.get(url);
                    } else {
	            	    var data = { "ids": id };
	            	    $.operate.submit(url, "post", "json", data);
	                }
            	});
            	
            },
            // 批量删除信息
            removeAll: function() {
        		var rows = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
        		if (rows.length == 0) {
        			$.modal.alertWarning("请至少选择一条记录");
        			return;
        		}
        		$.modal.confirm("确认要删除选中的" + rows.length + "条数据吗?", function() {
        			var url = $.table._option.removeUrl;
        			var data = { "ids": rows.join() };
        			$.operate.submit(url, "post", "json", data);
        		});
            },
            // 清空信息
            clean: function() {
            	$.modal.confirm("确定清空所有" + $.table._option.modalName + "吗？", function() {
	            	var url = $.table._option.cleanUrl;
	            	$.operate.submit(url, "post", "json", "");
            	});
            },
            // 添加信息
            add: function(id) {
                $.modal.open("添加" + $.table._option.modalName, $.operate.addUrl(id));
            },
            // 添加信息，以tab页展现
            addTab: function (id) {
                $.modal.openTab("添加" + $.table._option.modalName, $.operate.addUrl(id));
            },
            // 添加信息 全屏
            addFull: function(id) {
            	var url = $.common.isEmpty(id) ? $.table._option.createUrl : $.table._option.createUrl.replace("{id}", id);
                $.modal.openFull("添加" + $.table._option.modalName, url);
            },
            fullView: function(id) {
            	var url = $.common.isEmpty(id) ? $.table._option.viewUrl : $.table._option.viewUrl.replace("{id}", id);
                $.modal.openFullView("查看" + $.table._option.modalName, url);
            },
            view: function(id) {
            	var url = $.common.isEmpty(id) ? $.table._option.viewUrl : $.table._option.viewUrl.replace("{id}", id);
                $.modal.openView("查看" + $.table._option.modalName, url);
            },
            // 添加访问地址
            addUrl: function(id) {
            	var url = $.common.isEmpty(id) ? $.table._option.createUrl : $.table._option.createUrl.replace("{id}", id);
                return url;
            },
            // 修改信息
            edit: function(id) {
            	if($.common.isEmpty(id) && $.table._option.type == table_type.bootstrapTreeTable) {
            		var row = $('#' + $.table._option.id).bootstrapTreeTable('getSelections')[0];
                	if ($.common.isEmpty(row)) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
                    var url = $.table._option.updateUrl.replace("{id}", row[$.table._option.uniqueId]);
                    $.modal.open("修改" + $.table._option.modalName, url);
            	} else {
            	    $.modal.open("修改" + $.table._option.modalName, $.operate.editUrl(id));
            	}
            },
            // 修改信息
            editFun: function(id,fun) {
            	if($.common.isEmpty(id) && $.table._option.type == table_type.bootstrapTreeTable) {
            		var row = $('#' + $.table._option.id).bootstrapTreeTable('getSelections')[0];
                	if ($.common.isEmpty(row)) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
                    var url = $.table._option.updateUrl.replace("{id}", row[$.table._option.uniqueId]);
                    $.modal.openFun("修改" + $.table._option.modalName, url,"","","",fun,row[$.table._option.uniqueId]);
            	} else {
            	    var id = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
            	    if (id.length == 0) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
            	    $.modal.openFun("修改" + $.table._option.modalName, $.operate.editUrl(id),"","","",fun,id);
            	}
            },
            // 修改信息，以tab页展现
            editTab: function(id) {
            	$.modal.openTab("修改" + $.table._option.modalName, $.operate.editUrl(id));
            },
            // 修改信息 全屏
            editFull: function(id,fun) {
            	var url = "/404.html";
            	if ($.common.isNotEmpty(id)) {
            	    url = $.table._option.updateUrl.replace("{id}", id);
            	} else {
            	    var row = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
            	    url = $.table._option.updateUrl.replace("{id}", row);
            	    id=row[0];
            	}
            	$.modal.openFull("修改" + $.table._option.modalName, url, "", "", fun, id);
            },
            // 修改访问地址
            editUrl: function(id) {
            	var url = "/404.html";
            	if ($.common.isNotEmpty(id)) {
            	    url = $.table._option.updateUrl.replace("{id}", id);
            	} else {
            	    var id = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
            	    if (id.length == 0) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
            	    url = $.table._option.updateUrl.replace("{id}", id);
            	}
                return url;
            },
            common:function (id,title,field,type){
            	 var url ="";
            	if(type == "edit"){
            		eval("url=$.table._option." + field+ ";");
                	if($.common.isEmpty(id) && $.table._option.type == table_type.bootstrapTreeTable) {
                		var row = $('#' + $.table._option.id).bootstrapTreeTable('getSelections')[0];
                    	if ($.common.isEmpty(row)) {
                			$.modal.alertWarning("请至少选择一条记录");
                			return;
                		}
                        var url = url.replace("{id}", row[$.table._option.uniqueId]);
                        $.modal.open(title, url);
                	} else {
                	    $.modal.open(title, $.operate.commonUrl(id));
                	}
            		
            	}else{
            		 $.modal.open(title, $.operate.commonUrl(id));
            		
            	}
            },
            commonTab: function(id,title,field,type) {
            	$.modal.openTab(title, $.operate.commonUrl(id));
            },
            // 修改信息 全屏
            commonFull: function(id,title,field,type,fun) {
            	var url = "/404.html";
            	eval("url=$.table._option." + field+ ";");
            	if(type == "edit"){
            
	            	if ($.common.isNotEmpty(id)) {
	            		
	            	    url = url.replace("{id}", id);
	            	} else {
	            	    var row = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
	            	    
	            	    url = url.replace("{id}", row);
	            	    id=row[0];
	            	}
	            	$.modal.openFull(title, url, "", "", fun, id);
            	}else{
            		var url = $.common.isEmpty(id) ? url : url.replace("{id}", id);
                    $.modal.openFull(title, url);
            	}
            },
            commonUrl: function(id,field,type) {
            	var url = "/404.html";
            	if(type == undefined){
            		type ="add";
            	}
            	if(field == undefined){
            		$.modal.alertWarning("参数field错误");
        			return;
            	}
            	
        		eval("url=$.table._option." + field+ ";");
            	if(type == "add"){
            		
            		 url = $.common.isEmpty(id) ? url : url.replace("{id}", id);
            	}else{
	            	if ($.common.isNotEmpty(id)) {
	            	    url = url.replace("{id}", id);
	            	} else {
	            	    var id = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
	            	    if (id.length == 0) {
	            			$.modal.alertWarning("请至少选择一条记录");
	            			return;
	            		}
	            	    url = url.replace("{id}", id);
	            	}
            	}
                return url;
            },
            // 修改信息，以tab页展现
            viewTab: function(id) {
            	$.modal.openTab("修改" + $.table._option.modalName, $.operate.viewUrl(id));
            },
            // 修改访问地址
            viewUrl: function(id) {
            	var url = "/404.html";
            	if ($.common.isNotEmpty(id)) {
            	    url = $.table._option.viewUrl.replace("{id}", id);
            	} else {
            	    var id = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
            	    if (id.length == 0) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
            	    url = $.table._option.viewUrl.replace("{id}", id);
            	}
                return url;
            },
            // 修改访问地址
            reviewtUrl: function(id) {
            	var url = "/404.html";
            	if ($.common.isNotEmpty(id)) {
            	    url = $.table._option.reviewUrl.replace("{id}", id);
            	} else {
            	    var id = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
            	    if (id.length == 0) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
            	    url = $.table._option.reviewUrl.replace("{id}", id);
            	}
                return url;
            },
            // 修改信息
            review: function(id) {
            	if($.common.isEmpty(id) && $.table._option.type == table_type.bootstrapTreeTable) {
            		var row = $('#' + $.table._option.id).bootstrapTreeTable('getSelections')[0];
                	if ($.common.isEmpty(row)) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
                    var url = $.table._option.reviewUrl.replace("{id}", row[$.table._option.uniqueId]);
                    $.modal.open("审核" + $.table._option.modalName, url);
            	} else {
            	    $.modal.open("审核" + $.table._option.modalName, $.operate.reviewtUrl(id));
            	}
            },
            // 修改信息
            reviewFun: function(id,fun) {
            	if($.common.isEmpty(id) && $.table._option.type == table_type.bootstrapTreeTable) {
            		var row = $('#' + $.table._option.id).bootstrapTreeTable('getSelections')[0];
                	if ($.common.isEmpty(row)) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
                    var url = $.table._option.reviewUrl.replace("{id}", row[$.table._option.uniqueId]);
                    $.modal.openFun("修改" + $.table._option.modalName, url,"","","",fun,row[$.table._option.uniqueId]);
            	} else {
            	    var id = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
            	    if (id.length == 0) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
            	    $.modal.openFun("修改" + $.table._option.modalName, $.operate.reviewUrl(id),"","","",fun,id);
            	}
            },
            // 修改信息，以tab页展现
            reviewTab: function(id) {
            	$.modal.openTab("修改" + $.table._option.modalName, $.operate.reviewUrl(id));
            },
            // 修改信息 全屏
            reviewFull: function(id,fun) {
            	var url = "/404.html";
            	if ($.common.isNotEmpty(id)) {
            	    url = $.table._option.reviewUrl.replace("{id}", id);
            	} else {
            	    var row = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
            	    url = $.table._option.reviewUrl.replace("{id}", row);
            	    id=row[0];
            	}
            	$.modal.openFull("修改" + $.table._option.modalName, url, "", "", fun, id);
            },
            // 修改访问地址
            reportUrl: function(id) {
            	var url = "/404.html";
            	if ($.common.isNotEmpty(id)) {
            	    url = $.table._option.reportUrl.replace("{id}", id);
            	} else {
            	    var id = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
            	    if (id.length == 0) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
            	    url = $.table._option.reportUrl.replace("{id}", id);
            	}
                return url;
            },
            // 修改信息
            report: function(id) {
            	var url = "";
            	if($.common.isEmpty(id) && $.table._option.type == table_type.bootstrapTreeTable) {
            		var row = $('#' + $.table._option.id).bootstrapTreeTable('getSelections')[0];
                	if ($.common.isEmpty(row)) {
            			$.modal.alertWarning("请至少选择一条记录");
            			return;
            		}
                   url = $.table._option.reportUrl.replace("{id}", row[$.table._option.uniqueId]);
                   
            	} else {
            	   url = $.operate.reportUrl(id);// $.modal.open("审核" + $.table._option.modalName, );
            	}
              	$.modal.confirm("您确定要上报么？",function (){
            		$.operate.post(url, {mid:id});
            	});
            },
       
            // 修改信息 全屏
            reportFull: function(id,fun) {
            	var url = "/404.html";
            	if ($.common.isNotEmpty(id)) {
            	    url = $.table._option.reportUrl.replace("{id}", id);
            	} else {
            	    var row = $.common.isEmpty($.table._option.uniqueId) ? $.table.selectFirstColumns() : $.table.selectColumns($.table._option.uniqueId);
            	    url = $.table._option.reportUrl.replace("{id}", row);
            	    id=row[0];
            	}
            	//$.modal.openFull("修改" + $.table._option.modalName, url, "", "", fun, id);
            	$.modal.confirm("您确定要上报么？",function (){
            		$.operate.post(url, {mid:id});
            	});
            },       	/* 状态显示 */
    		 statusTools:function(row, name, field) {
    			 if(field == undefined){
    				 field = "status";
    			 }
    		    if (row.status == 1) {
        			return '<i class=\"fa fa-toggle-off text-info fa-2x\" onclick="$.operate.enable(\'' + row.mid + '\',\'' + name + '\',\'' + field + '\')"></i> ';
        		} else {
        			return '<i class=\"fa fa-toggle-on text-info fa-2x\" onclick="$.operate.disable(\'' + row.mid + '\',\'' + name + '\',\'' + field + '\')"></i> ';
        		}
    		},		
    		/* 启用 */
    		 enable:function(id,name,field) {
    			 
    			$.modal.confirm("确认要启用"+name+"吗？", function() {
    				$.operate.post($.table._option.changeStatusUrl, { "mid": id, field: 0 });
    		    })
    		},

    		/* -停用 */
    		 disable:function(id,name,field) {
    			$.modal.confirm("确认要停用"+name+"吗？", function() {
    				$.operate.post($.table._option.changeStatusUrl, { "mid": id, field: 1 });
    		    })
    		},
    		imgHtml:function(src){
    			return "<img style='width:50px' src='"+src+"' />";
    		},
            // 保存信息
            save: function(url, data) {
            	var config = {
        	        url: url,
        	        type: "post",
        	        dataType: "json",
        	        data: data,
        	        beforeSend: function () {
        	        	$.modal.loading("正在处理中，请稍后...");
        	        	$.modal.disable();
        	        },
        	        success: function(result) {
        	        	$.operate.successCallback(result);
        	        }
        	    };
        	    $.ajax(config)
            },
            // 保存信息
            ajax: function(url, data, fun, type) {
            	if(type == undefined || type == ''){
            		type = "post";
            	}
            	var config = {
        	        url: url,
        	        type: type,
        	        dataType: "json",
        	        data: data,
        	        beforeSend: function () {
        	        	$.modal.loading("正在处理中，请稍后...");
        	        	$.modal.disable();
        	        },
        	        success: function(result) {
        	        	//debugger;
                        if (result.code == web_status.SUCCESS) {
                        	if(fun != undefined && typeof fun == 'function'){
                        		fun(result);
                        	}
                        } else {
                            $.modal.alertError(result.msg);
                        }
                        $.modal.closeLoading();
                        $.modal.enable();
        	        }
        	    };
        	    $.ajax(config)
            },
            webAjax: function(url, data, fun, type) {
            	if(type == undefined || type == ''){
            		type = "post";
            	}
            	var config = {
        	        url: url,
        	        type: type,
        	        dataType: "json",
        	        data: data,
        	        beforeSend: function () {
        	        	$.modal.loading("正在处理中，请稍后...");
        	        	$.modal.disable();
        	        },
        	        success: function(result) {
        	        	//debugger;
                        if (result.code == web_status.SUCCESS) {
                        	if(fun != undefined && typeof fun == 'function'){
                        		fun(result);
                        	}
                        } else {
                            $.modal.alertError(result.msg);
                        }
                        $.modal.closeLoading();
                        $.modal.enable();
        	        }
        	    };
        	    $.ajax(config)
            },            
            // 保存选项卡信息
            saveTab: function(url, data) {
            	var config = {
        	        url: url,
        	        type: "post",
        	        dataType: "json",
        	        data: data,
        	        beforeSend: function () {
        	        	$.modal.loading("正在处理中，请稍后...");
        	        },
        	        success: function(result) {
        	        	$.operate.successTabCallback(result);
        	        }
        	    };
        	    $.ajax(config)
            },
            // 保存结果弹出msg刷新table表格
            ajaxSuccess: function (result) {
            	if (result.code == web_status.SUCCESS && $.table._option.type == table_type.bootstrapTable) {
                	$.modal.msgSuccess(result.msg);
            		$.table.refresh();
                } else if (result.code == web_status.SUCCESS && $.table._option.type == table_type.bootstrapTreeTable) {
                	$.modal.msgSuccess(result.msg);
                	$.treeTable.refresh();
                } else {
                	$.modal.alertError(result.msg);
                }
            	$.modal.closeLoading();
            },
            // 成功结果提示msg（父窗体全局更新）
            saveSuccess: function (result) {
            	if (result.code == web_status.SUCCESS) {
            		$.modal.msgReload("保存成功,正在刷新数据请稍后……", modal_status.SUCCESS);
                } else {
                	$.modal.alertError(result.msg);
                }
            	$.modal.closeLoading();
            },
            // 成功回调执行事件（父窗体静默更新）
            successCallback: function(result) {
                if (result.code == web_status.SUCCESS) {
                	var parent = window.parent;
                    if (parent.$.table._option.type == table_type.bootstrapTable) {
                        $.modal.close();
                        parent.$.modal.msgSuccess(result.msg);
                        parent.$.table.refresh();
                    } else if (parent.$.table._option.type == table_type.bootstrapTreeTable) {
                        $.modal.close();
                        parent.$.modal.msgSuccess(result.msg);
                        parent.$.treeTable.refresh();
                    } else {
                        $.modal.msgReload("保存成功,正在刷新数据请稍后……", modal_status.SUCCESS);
                    }
                } else {
                    $.modal.alertError(result.msg);
                }
                $.modal.closeLoading();
                $.modal.enable();
            },
            // 选项卡成功回调执行事件（父窗体静默更新）
            successTabCallback: function(result) {
                if (result.code == web_status.SUCCESS) {
                	var topWindow = $(window.parent.document);
    	            var currentId = $('.page-tabs-content', topWindow).find('.active').attr('data-panel');
    	            var $contentWindow = $('.RuoYi_iframe[data-id="' + currentId + '"]', topWindow)[0].contentWindow;
    	            $.modal.close();
    	            $contentWindow.$.modal.msgSuccess(result.msg);
    	            $contentWindow.$(".layui-layer-padding").removeAttr("style");
    	            if ($contentWindow.$.table._option.type == table_type.bootstrapTable) {
    	        		$contentWindow.$.table.refresh();
    	        	} else if ($contentWindow.$.table._option.type == table_type.bootstrapTreeTable) {
    	        		$contentWindow.$.treeTable.refresh();
                    }
    	            closeItem();
                } else {
                    $.modal.alertError(result.msg);
                }
                $.modal.closeLoading();
            }
        },
        // 校验封装处理
        validate: {
        	// 判断返回标识是否唯一 false 不存在 true 存在
        	unique: function (value) {
            	if (value == "0") {
                    return true;
                }
                return false;
            },
            // 表单验证
            form: function (formId) {
            	var currentId = $.common.isEmpty(formId) ? $('form').attr('id') : formId;
                return $("#" + currentId).validate().form();
            }
        },
        // 树插件封装处理
        tree: {
        	_option: {},
        	_lastValue: {},
        	// 初始化树结构
        	init: function(options) {
        		var defaults = {
            		id: "tree",                    // 属性ID
            		expandLevel: 0,                // 展开等级节点
            		view: {
    			        selectedMulti: false,      // 设置是否允许同时选中多个节点
    			        nameIsHTML: true           // 设置 name 属性是否支持 HTML 脚本
    			    },
            		check: {
    				    enable: false,             // 置 zTree 的节点上是否显示 checkbox / radio
    				    nocheckInherit: true,      // 设置子节点是否自动继承
    				},
    				data: {
    			        key: {
    			            title: "title"         // 节点数据保存节点提示信息的属性名称
    			        },
    			        simpleData: {
    			            enable: true           // true / false 分别表示 使用 / 不使用 简单数据模式
    			        }
    			    },
        		};
            	var options = $.extend(defaults, options);
        		$.tree._option = options;
        		// 树结构初始化加载
        		var setting = {
    				callback: {
    			        onClick: options.onClick,                      // 用于捕获节点被点击的事件回调函数
    			        onCheck: options.onCheck,                      // 用于捕获 checkbox / radio 被勾选 或 取消勾选的事件回调函数
    			        onDblClick: options.onDblClick                 // 用于捕获鼠标双击之后的事件回调函数
    			    },
    				check: options.check,
    			    view: options.view,
    			    data: options.data
    			};
        	    $.get(options.url, function(data) {
        			var treeId = $("#treeId").val();
        			tree = $.fn.zTree.init($("#" + options.id), setting, data);
        			$._tree = tree;
        			var nodes = tree.getNodesByParam("level", options.expandLevel - 1);
        			for (var i = 0; i < nodes.length; i++) {
        				tree.expandNode(nodes[i], true, false, false);
        			}
        			var node = tree.getNodesByParam("id", treeId, null)[0];
        			if(node != undefined)
        			$.tree.selectByIdName(treeId, node);
        		});
        	},
        	initAsync: function(options) {
        		var defaults = {
            		id: "tree",                    // 属性ID
            		expandLevel: 0,                // 展开等级节点
            		view: {
    			        selectedMulti: false,      // 设置是否允许同时选中多个节点
    			        nameIsHTML: true           // 设置 name 属性是否支持 HTML 脚本
    			    },
            		check: {
    				    enable: false,             // 置 zTree 的节点上是否显示 checkbox / radio
    				    nocheckInherit: true,      // 设置子节点是否自动继承
    				},
    				data: {
    			        key: {
    			            title: "title"         // 节点数据保存节点提示信息的属性名称
    			        },
    			        simpleData: {
    			            enable: false           // true / false 分别表示 使用 / 不使用 简单数据模式
    			        }
    			    },
        		};
            	var options = $.extend(defaults, options);
        		$.tree._option = options;
        		// 树结构初始化加载
        		var setting = {
    				callback: {
    			        onClick: options.onClick,                      // 用于捕获节点被点击的事件回调函数
    			        onCheck: options.onCheck,                      // 用于捕获 checkbox / radio 被勾选 或 取消勾选的事件回调函数
    			        onDblClick: options.onDblClick                 // 用于捕获鼠标双击之后的事件回调函数
    			    },
    				check: options.check,
    			    view: options.view,
    			    data: options.data,
    			    async:options.async,
    			};
        	   
        			var treeId = $("#treeId").val();
        			tree = $.fn.zTree.init($("#" + options.id), setting);
        			$._tree = tree;
        			var nodes = tree.getNodesByParam("level", options.expandLevel - 1);
        			for (var i = 0; i < nodes.length; i++) {
        				tree.expandNode(nodes[i], true, false, false);
        			}
        			var node = tree.getNodesByParam("id", treeId, null)[0];
        			if(node != undefined)
        			$.tree.selectByIdName(treeId, node);
        		
        	},
        	// 搜索节点
        	searchNode: function() {
        		// 取得输入的关键字的值
        		var value = $.common.trim($("#keyword").val());
        		if ($.tree._lastValue == value) {
        		    return;
        		}
        		// 保存最后一次搜索名称
        		$.tree._lastValue = value;
        		var nodes = $._tree.getNodes();
        		// 如果要查空字串，就退出不查了。
        		if (value == "") {
        		    $.tree.showAllNode(nodes);
        		    return;
        		}
        		$.tree.hideAllNode(nodes);
        		// 根据搜索值模糊匹配
        		$.tree.updateNodes($._tree.getNodesByParamFuzzy("name", value));
        	},
        	// 根据Id和Name选中指定节点
        	selectByIdName: function(treeId, node) {
        		if ($.common.isNotEmpty(treeId) && treeId == node.id) {
        			$._tree.selectNode(node, true);
        		}
        	},
        	// 显示所有节点
        	showAllNode: function(nodes) {
        		nodes = $._tree.transformToArray(nodes);
        		for (var i = nodes.length - 1; i >= 0; i--) {
        		    if (nodes[i].getParentNode() != null) {
        		    	$._tree.expandNode(nodes[i], true, false, false, false);
        		    } else {
        		    	$._tree.expandNode(nodes[i], true, true, false, false);
        		    }
        		    $._tree.showNode(nodes[i]);
        		    $.tree.showAllNode(nodes[i].children);
        		}
        	},
        	// 隐藏所有节点
        	hideAllNode: function(nodes) {
        	    var tree = $.fn.zTree.getZTreeObj("tree");
        	    var nodes = $._tree.transformToArray(nodes);
        	    for (var i = nodes.length - 1; i >= 0; i--) {
        	    	$._tree.hideNode(nodes[i]);
        	    }
        	},
        	// 显示所有父节点
        	showParent: function(treeNode) {
        		var parentNode;
        		while ((parentNode = treeNode.getParentNode()) != null) {
        			$._tree.showNode(parentNode);
        			$._tree.expandNode(parentNode, true, false, false);
        		    treeNode = parentNode;
        		}
        	},
        	// 显示所有孩子节点
        	showChildren: function(treeNode) {
        		if (treeNode.isParent) {
        		    for (var idx in treeNode.children) {
        		        var node = treeNode.children[idx];
        		        $._tree.showNode(node);
        		        $.tree.showChildren(node);
        		    }
        		}
        	},
        	// 更新节点状态
        	updateNodes: function(nodeList) {
        		$._tree.showNodes(nodeList);
        		for (var i = 0, l = nodeList.length; i < l; i++) {
        		    var treeNode = nodeList[i];
        		    $.tree.showChildren(treeNode);
        		    $.tree.showParent(treeNode)
        		}
        	},
        	// 获取当前被勾选集合
        	getCheckedNodes: function(column) {
        		var _column = $.common.isEmpty(column) ? "id" : column;
        		var nodes = $._tree.getCheckedNodes(true);
        		return $.map(nodes, function (row) {
        	        return row[_column];
        	    }).join();
        	},
        	// 不允许根父节点选择
        	notAllowParents: function(_tree) {
    		    var nodes = _tree.getSelectedNodes();
    		    for (var i = 0; i < nodes.length; i++) {
    		        if (nodes[i].level == 0) {
    		            $.modal.msgError("不能选择根节点（" + nodes[i].name + "）");
    		            return false;
    		        }
    		        if (nodes[i].isParent) {
    		            $.modal.msgError("不能选择父节点（" + nodes[i].name + "）");
    		            return false;
    		        }
    		    }
        		return true;
        	},
        	// 不允许最后层级节点选择
        	notAllowLastLevel: function(_tree) {
    		    var nodes = _tree.getSelectedNodes();
    		    for (var i = 0; i < nodes.length; i++) {
    		    	if (nodes[i].level == nodes.length + 1) {
    		    		$.modal.msgError("不能选择最后层级节点（" + nodes[i].name + "）");
    		            return false;
    		        }
    		    }
        		return true;
        	},
        	// 隐藏/显示搜索栏
        	toggleSearch: function() {
        		$('#search').slideToggle(200);
        		$('#btnShow').toggle();
        		$('#btnHide').toggle();
        		$('#keyword').focus();
        	},
        	// 折叠
        	collapse: function() {
        		$._tree.expandAll(false);
        	},
        	// 展开
        	expand: function() {
        		$._tree.expandAll(true);
        	}
        },
        // 通用方法封装处理
    	common: {
    		guid: function () {
    		    function S4() {
    		       return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
    		    }
    		    return (S4()+S4());
    		},
    		showHide: function (show,ids){
    			if(ids == undefined || ids == ''){
    				return '';
    			}
    			var idsArray = ids.split(",");
    			var value ="";
    			if(show == 1){
    				value = "block";
    				
    			}else{
    				value = "none";
    				
    			}
    			for(var i in idsArray){
    				$("#" + idsArray[i]).css("display","none");
    			}
    		},
    		cascade:function (url,id,name,levelType,isDefault,eventFlag, fun){
    			$("#"+id).empty();
    			var level = 0;
    			if(levelType == 0){
    				levelType = 3;
    			}
    			var width = 12 / levelType;
    			var com = {
    					
    				createHtml:function (id, width,name,index,url,option,eventFlag){
    					var shtml = "<div  class='col-sm-"+width+" div-pdding-left'><select class='form-control'  lb-id='"+id+"' lb-width='"+width+"' lb-url='"+url+"' lb-index='"+index+"' id="+name+" lb-cascade="+eventFlag+" name="+name+">"+option+"</select></div>";
    					
    					return shtml;
    				},
    				severData: function (id, width,selectId,index,isdefault,  data, eventFlag){
    	            	var config = {
    	            	        url: url,
    	            	        type: "post",
    	            	        dataType: "json",
    	            	        data: data,
    	            	        success: function(result) {
    	            	        	com.callfun(id, width,selectId,index,url,isdefault,result, eventFlag);
    	            	        }
    	            	    };
    	            	    $.ajax(config)
    					
    				},
    				callfun: function(id, width,selectId,index,url,isdefault, result, eventFlag){
    					var option = "<option value=''>请选择</option>";
    				
    					if(result.code==0){
    						var data = result.data
    						for(var i in data){
    							if(isdefault == data[i].mid){
    								//selected=selected
    								option += "<option selected='selected' value='"+data[i].mid+"'>" + data[i].name+"</option>";
    							}else{
    								option += "<option value='"+data[i].mid+"'>" + data[i].name+"</option>";
    							}
    						}
    						if($("#"+selectId).size()>0){
    							$("#"+selectId).empty();
    							$("#"+selectId).append(option);
    							
    						}else{
    							if(data.length>0){
		    					var	str = com.createHtml(id, width, selectId, index,url, option, eventFlag);
		    					$("#"+id).append(str);
    							}
    						}
    					}else{
    						$.modal.alertWarning(result.msg);
    					}
    				}
    					
    			}
    			function init(){
    				
    				if(isDefault != undefined && isDefault != ""){
    					var isDefaultArray = isDefault.split(',');
    					var isdefault = "";
    					for(var i in isDefaultArray){
    						if(i == 0){
    							isdefault=0;
    						}else{
    							isdefault = isDefaultArray[i-1];
    						}
    						
    						com.severData(id, width, name+i, i,isDefaultArray[i], {"parentId":isdefault},eventFlag);
    					}
    				}
    				
    				
    			}
    		/**	$("select[lb-cascade]").change(
    			   function (){
    				   debugger;
    						var lbID = $(this).attr("lb-id");
    						var value = $(this).val();
    						var lbIndex = ParseInt($(this).attr("lb-index"))+1;
    						var lbWidth = $(this).attr("lb-width");
    						var name = $(this).attr("name").substr(-1,1);
    						var lbCascade = $(this).attr("lb-cascade");
    						com.severData(lbID, lbWidth, name+lbIndex, lbIndex, 0,{"parentId":value},lbCascade);	
    			});
    			*/
    			$(document).on("change", "select[lb-cascade="+eventFlag+"]", function (e){
    				e.preventDefault();
 			
					var lbID = $(this).attr("lb-id");
					var value = $(this).val();
					var lbIndex = parseInt($(this).attr("lb-index"))+1;
					var lbWidth = $(this).attr("lb-width");
					var name = $(this).attr("name");
					name = name.substr(0,name.length-1);
					var lbCascade = $(this).attr("lb-cascade");
					var levelType = 12/parseInt(lbWidth);
					if(levelType < lbIndex+1){
						return false;
					}
					var index = parseInt($(this).attr("lb-index"));
					for(var i =0; i< levelType;i++){
						index++;
						$("#"+name+index).parent("div").detach();
					}
					com.severData(lbID, lbWidth, name+lbIndex, lbIndex, 0,{"parentId":value},lbCascade);	
					e.stopPropagation();
					if(fun != undefined && typeof fun == "function"){
						
						fun(value);
					}
		}	
    			);

    			/***
    			 * 初始化
    			 * @param value
    			 * @returns
    			 */
    			init();
    			
    		},
			getCascadeValue:function (id){//localName
				
				var value = "";
				$("#"+id).children("div").children("select").each(function (){
					
					var valueStr = $(this).val();
					if(valueStr.length != 0){
						value += "," + $(this).val();
					}
					
					
				});
				return $.common.trimStr(value,",");
				
			},
			getCascadeValue1:function (id){//localName
				
				var value = [];
				$("#"+id).children("div").children("select").each(function (){
					
					var valueStr = $(this).val();
					if(valueStr.length != 0){
						value .push(valueStr);
					}
				});
				return value.length==0?"":value[0];
			},
			getCascadeValue2:function (id){//localName
				
				var value = [];
				$("#"+id).children("div").children("select").each(function (){
					var valueStr = $(this).val();
					if(valueStr.length != 0){
						value .push(valueStr);
					}
				});
				return value.length >=2 ? value[1]:"";	
			},
			getCascadeLastValue:function (id){
				
				var value = [];
			
				$("#"+id).children("div").children("select").each(function (){
					var valueStr = $(this).val();
					if(valueStr.length != 0){
						value .push(valueStr);
					}
					
				});
				
				return value[value.length-1];
				
			},
			getCascadeTitle:function (id){
				
					var title = "";
					$("#"+id).children("div").children("select").each(function (){
						
					var	value = $(this).val();
					var text = $(this).children("option[value="+value+"]").text();
					title += "-" + text;
				});
				return $.common.trimStr(title,"-");
			},
    		areaCascade:function (url,id,name,isDefault,fun){
    			if(isDefault==undefined){
    				isDefault = "0";
    			}
    			if(fun != undefined && fun == ""){
					
    				fun= undefined;
				}
    			$.common.cascade(url,id,name,3,isDefault,name,fun);
    		},
    		categoryCascade:function (url,id,name,isDefault,fun){
    			if(isDefault==undefined || isDefault==''){
    				isDefault = "0";
    			}
    			if(fun == undefined && fun == ""){
					
					fun= undefined;
				}
    			$.common.cascade(url,id,name,3,isDefault,name,fun);
    		},
    		imgYL1:function (id){
    			layer.open({
    				  type: 1,
    				  title: false,
    				  closeBtn: 0,
    				  area: ['auto'],
    				  skin: 'layui-layer-nobg', //没有背景色
    				  shadeClose: true,
    				  content: $('#'+id)
    				});
    		},
    		imgYL:function (id, type){
    			//debugger;
    			if(type == undefined){
    				type = 1;
    			}
    			layer.photos({
    				  photos: '#'+id
    				  ,anim: type //0-6的选择，指定弹出图片动画类型，默认随机（请注意，3.0之前的版本用shift参数）
    				}); 
    		},
    		uplodFile:function (id, idName, idYl, multiple, upload){
  			  upload.render({
  			    elem: '#'+id
  			    ,url:  ctx + "common/upload" //改成您自己的上传接口
  			    ,multiple: multiple
  			    ,before: function(obj){
  			      //预读本地文件示例，不支持ie8
  			      obj.preview(function(index, file, result){
  			    	  if(multiple == false){
  			    		$('#'+ idYl).empty();
  			    	  }
  			        $('#'+ idYl).append('<img style="width:120px" id= "'+idYl+'img"  src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
  			      //$.common.imgYL1(idYl+"img");onclick="$.common.imgYL1(\''+idYl+'img\')"
  			  	$.common.imgYL(idYl, 5);
  			      });
  			    }
  			    ,done: function(res){
  			      //上传完毕
  			     $('#' + idName).val(res.fileName);
  			    },
  			    error: function(){
  			      //演示失败状态，并实现重传
  			      //var demoText = $('#'+id);
  			     // demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
  			      $.modal.msgError("上传失败");
  			    }
  			  });
    			
    		},
    		uplodImg:function (id, idName, idYl, multiple, upload, fun){
    			  upload.render({
    			    elem: '#'+id
    			    ,url:  ctx + "common/upload" //改成您自己的上传接口
    			    ,multiple: multiple
    			    ,before: function(obj){
    			      //预读本地文件示例，不支持ie8
    			      obj.preview(function(index, file, result){
    			    	  
    			    	  if(multiple == false){
    	  			    		$('#'+ idYl).empty();
    	  			    	  }
    			        $('#'+ idYl).append('<img style="width:120px" id= "'+idYl+'img"  src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
    			      //$.common.imgYL1(idYl+"img");onclick="$.common.imgYL1(\''+idYl+'img\')"
    			        $.common.imgYL(idYl, 5);
    			      });
    			    }
    			    ,done: function(res){
    			      //上传完毕
    			    	if(fun != undefined && typeof fun == 'function'){
    			    		fun(res);
    			    	}else{
    			    		 $('#' + idName).val(res.fileName);
    			    	}
    			    },
    			    error: function(){
    			      //演示失败状态，并实现重传
    			      //var demoText = $('#'+id);
    			     // demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
    			      $.modal.msgError("上传失败");
    			    }
    			  });
      			
      		},
    		uplodVideo:function (id, idName, idYl,upload, fun){
  			  upload.render({
  			    elem: '#'+id
  			    ,url:  ctx + "common/upload" //改成您自己的上传接口
  			  ,accept: 'video' //视频
  			    ,before: function(obj){
  			      //预读本地文件示例，不支持ie8
  			      obj.preview(function(index, file, result){
  			        $('#'+ idYl).append('<img style="width:120px" id= "'+idYl+'img"  src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">')
  			      //$.common.imgYL1(idYl+"img");onclick="$.common.imgYL1(\''+idYl+'img\')"
  			        $.common.imgYL(idYl, 5);
  			      });
  			    }
  			    ,done: function(res){
  			      //上传完毕
  			    	if(fun != undefined && typeof fun == 'function'){
  			    		fun(res);
  			    	}
  			    },
  			    error: function(){
  			      //演示失败状态，并实现重传
  			      //var demoText = $('#'+id);
  			     // demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
  			      $.modal.msgError("上传失败");
  			    }
  			  });
    			
    		}, 
    	    // 上传文件
    	     summernoteUploadFile:function(file, obj) {
    	        var data = new FormData();
    	        data.append("file", file);
    	        $.ajax({
    	            type: "POST",
    	            url: ctx + "common/upload",
    	            data: data,
    	            cache: false,
    	            contentType: false,
    	            processData: false,
    	            dataType: 'json',
    	            success: function(result) {
    	                if (result.code == web_status.SUCCESS) {
    	                	$(obj).summernote('editor.insertImage', result.url, result.fileName);
    					} else {
    						$.modal.alertError(result.msg);
    					}
    	            },
    	            error: function(error) {
    	                $.modal.alertWarning("图片上传失败。");
    	            }
    	        });
    	    },
    		getCheckboxValue:function (id){
    			return $(id).is(':checked') == false ? 0 : 1;
    		},
    		getRadioBoxValue:function (id){
    			return $(id).val();
    		},
    		// 判断字符串是否为空
            isEmpty: function (value) {
                if (value == null || this.trim(value) == "") {
                    return true;
                }
                return false;
            },
            // 判断一个字符串是否为非空串
            isNotEmpty: function (value) {
            	return !$.common.isEmpty(value);
            },
            // 空对象转字符串
            nullToStr: function(value) {
                if ($.common.isEmpty(value)) {
                    return "-";
                }
                return value;
            },
            // 是否显示数据 为空默认为显示
            visible: function (value) {
                if ($.common.isEmpty(value) || value == true) {
                    return true;
                }
                return false;
            },
            // 空格截取
            trim: function (value) {
                if (value == null) {
                    return "";
                }
                return value.toString().replace(/(^\s*)|(\s*$)|\r|\n/g, "");
            },
            trimStr:function (value, str, type){
                if (value == null) {
                    return "";
                }
                if (str == null) {
                    return "";
                }
                if (str) {
                    if (type == 'left') {
                      return value.replace(new RegExp('^\\'+str+'+', 'g'), '');
                    } else if (type == 'right') {
                      return value.replace(new RegExp('\\'+str+'+$', 'g'), '');
                    }
                    return value.replace(new RegExp('^\\'+str+'+|\\'+str+'+$', 'g'), '');
                  }
                  return value.replace(/^\s+|\s+$/g, '');
            },
            // 指定随机数返回
            random: function (min, max) {
                return Math.floor((Math.random() * max) + min);
            },
            startWith: function(value, start) {
                var reg = new RegExp("^" + start);
                return reg.test(value)
            },
            endWith: function(value, end) {
                var reg = new RegExp(end + "$");
                return reg.test(value)
            }
        }
        ,
        bootstrapTable:{
        	inputFormatter:	function (value, name, row, ele){
        		return '<input class="form-control" tabid="'+row.id+name+'"  onblur="$.bootstrapTable.save(\''+row.id+'\',this ,\''+name+'\' ,\''+ele+'\')"  type="text"  value="'+value+'"  />';
        	},
        	//更新行
        	updateRow :function (id, index, row){
        		$('#' + id).bootstrapTable('updateByUniqueId', {index: index, row: row});
        	},
        	//保存计划数量
        	save: function (id, obj, name, ele){
        		var value = obj.value;
        		//debugger;
        		var row = $.bootstrapTable.getRowByUniqueId(ele, id);
        		eval("row."+name+"='"+value+"';");
        		$.bootstrapTable.updateRow(id,row);
        	},
        	insertRow: function (row, ele){
            	var rows = $('#'+ele).bootstrapTable('getData');
            	row.id = rows.length+1;
            	$('#'+ele).bootstrapTable('insertRow', {index: length+1, row: row});
            },
            removeBtn: function (ele){
            	if(ids == 	undefined || ids.length == 0){
            	  var ids = $.map($('#'+ele).bootstrapTable('getSelections'), function (row) {
            	        return row.id;
            	      })
            	}
             	  if(ids.length > 0){
        	        	$('#'+ele).bootstrapTable('remove', {field: 'id', values: ids});
        	        	  $.modal.msgSuccess("删除成功");
        	        	  return false;
             	  }
            },
            //选择位置
            /**
             * data[] = {dictValue:"",dictLabel:""}
             */
            inputSelectFormatter: function (value, name, nameId, data, row, ele){
            	var str = "<select class='form-control' lb-name='inputSelectFormatter'  name='"+name+"' nameid='"+nameId+"' rid='"+row.id+"' value='"+value+"' lb-id='"+ele+"' > ";
            	var option = "";
            	
            	for(var x in data){
            		if(data[x].dictValue==value){
            			option += "<option  selected = 'selected'  value='"+data[x].dictValue+"'>" + data[x].dictLabel+ "</option>";
            		}else{
            			option += "<option value='"+data[x].dictValue+"'>" + data[x].dictLabel+ "</option>";
            		}
            	}
            	str = str+ option + "</select>";
            	return str;
            },//下拉框回调事件
            selectChangeEventCallback:function (){
            	
              	var value = $(this).val();
    	       	var index = $(this).attr("rid");//行ID
    	       	var name = $(this).attr("name");//保存的名称
    	       	var lbId = $(this).attr("lb-id");
    	       	
    	       	var row = $.bootstrapTable.getRowByUniqueId(lbId, index);
    	       
    	       	var nameId = $(this).attr("nameid");
    	       	var text = $(this).find("option[value="+value+"]").text();
    	       	eval("row."+nameId+"='"+text+"'");
    	       	eval("row."+name+"='"+value+"'");
    	       	$.bootstrapTable.updateRow(index,row);
            },//下拉框事件
            selectChangeEvent:function (){
            	
                $(document).on("change","select[rid]", function (){
                	$.bootstrapTable.selectChangeEventCallback();
                })
            },
			/**
			是否需要拆解
			
			inputRadioFormatter
			
			*/
            inputRadioFormatter:function (value, name, row, ele){
				var html="";//onblur="$.bootstrapTable.save(\''+row.id+'\',this ,\''+name+'\' ,\''+ele+'\')"
				if(value == "1"){
					html = "是<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='1' name='"+name+row.id+"' checked='true' />";
					html += "否<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='0' name='"+name+row.id+"' />";
					html += "其他<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='3' name='"+name+row.id+"' />";
				}else if(value == "0"){
					html = "是<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='1' name='"+name+row.id+"' />";
					html += "否<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='0' name='"+name+row.id+"'  checked='true' />";
					html += "其他<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='2' name='"+name+row.id+"' />";
				}else{
					html = "是<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='1' name='"+name+row.id+"' />";
					html += "否<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='0' name='"+name+row.id+"'   />";
					html += "其他<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='2' name='"+name+row.id+"' checked='true' />";
				}
				
				return html;
			},         
			inputRadioYesOrNoFormatter:function (value, name, row, ele){
				var html="";//onblur="$.bootstrapTable.save(\''+row.id+'\',this ,\''+name+'\' ,\''+ele+'\')"
				if(value == "1"){
					html = "是<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='1' name='"+name+row.id+"' checked='true' />";
					html += "否<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='0' name='"+name+row.id+"' />";
					//html += "其他<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='3' name='"+name+row.id+"' />";
				}else if(value == "0"){
					html = "是<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='1' name='"+name+row.id+"' />";
					html += "否<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='0' name='"+name+row.id+"'  checked='true' />";
					//html += "其他<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='2' name='"+name+row.id+"' />";
				}
				return html;
			},
			inputRadioYesFormatter:function (value, name, row, ele){
				var html="";//onblur="$.bootstrapTable.save(\''+row.id+'\',this ,\''+name+'\' ,\''+ele+'\')"
				if(value == "1"){
					html = "是<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='1' name='"+name+"' checked='true' />";
					//html += "否<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='0' name='"+name+row.id+"' />";
					//html += "其他<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='3' name='"+name+row.id+"' />";
				}else{
					html = "是<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='1' name='"+name+"' />";
				//	html += "否<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'  value='0' name='"+name+row.id+"'  checked='true' />";
					//html += "其他<input type='radio' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+name+"\",\""+ele+"\")'   value='2' name='"+name+row.id+"' />";
				}
				return html;
			},			
			/*dataName={
			labelName:"",
			eleFiled:"",//标签name
			labelValue:"",//标签值
        	}*/
            inputCheckboxFormatter:function (values, dataName, row, ele){
				var html="";//onblur="$.bootstrapTable.save(\''+row.id+'\',this ,\''+name+'\' ,\''+ele+'\')"
				
				for(var i in dataName){
					var booleanFlag = false;
					//booleanFlag = values.+dataName[i].eleFiled  == undefined;
					
					var value = "";
					if(booleanFlag ){
						eval("value = values."+dataName[i].eleFiled+";");
					}
					
					if(value == dataName[i].labelValue ){
						html += dataName[i].labelName + "<input type='checkbox' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+dataName[i].eleFiled+"\",\""+ele+"\")'  value='"+dataName[i].labelValue+"' name='"+dataName[i].eleFiled+row.id+"' checked='true' />";
					}else{
						html += dataName[i].labelName + "<input type='checkbox' onclick='$.bootstrapTable.save(\""+row.id+"\",this,\""+dataName[i].eleFiled+"\",\""+ele+"\")'  value='"+dataName[i].labelValue+"' name='"+dataName[i].eleFiled+row.id+"' />";
					}
				}
				
				return html;
			},	
            inputCheckboxFunFormatter:function (values, dataName, row, ele, fun){
				var html="";//onblur="$.bootstrapTable.save(\''+row.id+'\',this ,\''+name+'\' ,\''+ele+'\')"
				
				for(var i in dataName){
					var booleanFlag = false;
					//booleanFlag = values.+dataName[i].eleFiled  == undefined;
					
					var value = "";
					if(booleanFlag ){
						eval("value = values."+dataName[i].checkValue+";");
					}
					
					if(value == dataName[i].labelValue ){
						html += dataName[i].labelName + "<input type='checkbox' lb-name='inputCheckboxFunFormatter'  onclick='"+fun+"(\""+row.id+"\",this,\""+dataName[i].eleFiled+"\",\""+ele+"\")'  value='"+dataName[i].labelValue+"' name='"+dataName[i].eleFiled+"' checked='true' />";
					}else{
						html += dataName[i].labelName + "<input type='checkbox' lb-name='inputCheckboxFunFormatter' onclick='"+fun+"(\""+row.id+"\",this,\""+dataName[i].eleFiled+"\",\""+ele+"\")'  value='"+dataName[i].labelValue+"' name='"+dataName[i].eleFiled+"' />";
					}
				}
				
				return html;
			},
			getRowByUniqueId:function (ele, index){
				
				return $('#' + ele ).bootstrapTable('getRowByUniqueId', index);
			},//获取全部数据
			getData:function (id){
				return $('#' + id).bootstrapTable('getData');
			},
	        //获取数据
			getDataJson:function (id, fun){
				
				var objects = $("#"+id).html();
				if(objects.length == 0){
					return false;
				}
	        	var object = $.bootstrapTable.getData(id);
	        	var newObject = [];
	        	for(var i in object){
	        		if(fun != undefined && typeof fun == 'function'){
	        			var result = fun(object[i]);
	        			if(result == true){
	        				newObject.push(object[i]);
	        			}else{
	        				$.modal.alertWarning(result);
	        				return false;
	        			}
	        		}else{
	        			newObject.push(object[i]);
	        		}
	        		
	        	}
	        	if(newObject.length == 0){
	        		return false;
	        	}
	        	return JSON.stringify(newObject);
	        },
	        load:function (id, data){
	           
	           $('#'+id).bootstrapTable("load",data);
	        
	        }
	          
        }
    });
})(jQuery);

/** 表格类型 */
table_type = {
    bootstrapTable: 0,
    bootstrapTreeTable: 1
};

/** 消息状态码 */
web_status = {
    SUCCESS: 0,
    FAIL: 500
};

/** 弹窗状态码 */
modal_status = {
    SUCCESS: "success",
    FAIL: "error",
    WARNING: "warning"
};
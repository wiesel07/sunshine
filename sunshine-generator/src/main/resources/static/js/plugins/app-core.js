/**
 * 通用方法封装处理
 * Copyright (c) 2018 wuj
 */
(function ($) {
	 $.extend({
		 // 表格树封装处理
	     treeTable: {
	        _option: {},
	        _treeTable: {},
	        // 初始化表格
	        init: function(options) {
	            $.treeTable._option = options;
	            var treeTable = $('#bootstrap-treeTable').bootstrapTreeTable(options);
	            $.treeTable._treeTable = treeTable;
	        },
	        // 条件查询
	        search: function(formId) {
	        	var currentId = app.isEmpty(formId) ? $('form').attr('id') : formId;
	        	var params = {};
	        	$.each($("#" + currentId).serializeArray(), function(i, field) {
	        		params[field.name] = field.value;
		        });
	        	$.treeTable._treeTable.bootstrapTreeTable('refresh', params);
	        },
	        // 刷新
	        refresh: function() {
	        	$.treeTable._treeTable.bootstrapTreeTable('refresh');
	        }
	    }
	 });
	 
	  $(document).ajaxStart(function () {
	        var index = layer.load(1, {
	            shade: [0.1, '#fff'] //0.1透明度的白色背景
	        });
	    });
	    $(document).ajaxStop(function () {
	        layer.closeAll('loading');
	    });
	    //登录过期，shiro返回登录页面
	    $.ajaxSetup({
	        complete: function (xhr, status,dataType) {
	            if('text/html;charset=UTF-8'==xhr.getResponseHeader('Content-Type')){
	                top.location.href = '/login';
	            }
	        }
	    });
})(jQuery);

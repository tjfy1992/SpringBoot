
/**
 * 前端工具类
 */

//设置cookie键值对,值解析为JSON字符串
var setCookie = function(key, value){
	var str = JSON.stringify(value)	
	document.cookie = key + "=" + str;
}

//在cookie中通过键名获取JSON格式的值并解析为对象,若未取到则返回空
var getCookie = function(cname){
    var name = cname + "=";
    var cookieValue = document.cookie.trim();
    return cookieValue.indexOf(name)==0?JSON.parse(cookieValue.substring(name.length,cookieValue.length)):null;
}

//时间日期格式化
var format = function(time, format){
	var t = new Date(time);
	var tf = function(i){return (i < 10 ? '0' :'') + i};
	return format.replace(/yyyy|MM|dd|HH|mm|ss/g, function(a)
	{
		switch(a)
		{
			case 'yyyy':
				return tf(t.getFullYear());
				break;
			case 'MM':
				return tf(t.getMonth() + 1);
				break;
			case 'mm':
				return tf(t.getMinutes());
				break;
			case 'dd':
				return tf(t.getDate());
				break;
			case 'HH':
				return tf(t.getHours());
				break;
			case 'ss':
				return tf(t.getSeconds());
				break;
		}
	})
}

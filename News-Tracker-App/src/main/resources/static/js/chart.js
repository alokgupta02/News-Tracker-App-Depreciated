/*$.ajax({
	url:'/admin/inputChart',
	success: function(result){
		var day = JSON.parse(result).day;
		var news = JSON.parse(result).news;
		drawBarChart(day, news);
	}
})

function drawBarChart(day, news){*/
	
Highcharts.chart('container',{
	chart: {
		type: 'line',
		widht: 500
	},
	title: {
		text: 'Line Chart'
	},
	xAxis: {
		categories:day
	},
	tooltip: {
		formatter: function(){
			console.log(this);
		}
	},
	series:[{
		data: news
	}]
});
}
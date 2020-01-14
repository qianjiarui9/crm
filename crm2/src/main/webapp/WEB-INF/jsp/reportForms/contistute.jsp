<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 客户构成分析 -->
<div id="customerConstitute">
<div>
  <form class="form-inline">
  <div class="form-group">
	<select name="condit" id="form-control">
		<option value="0" selected="selected">按等级</option>
		<option value="1">按信用度</option>
		<option value="2">按满意度</option>
	</select>
	
  </div>
 <!--  <div class="form-group">
	<select name="city" id="" class="form-control">
		 <option value="">请选择所属地区</option>
        <option value="华中">华中</option>
        <option value="华北">华北</option>
        <option value="华南">华南</option>
        <option value="华东">华东</option>
	</select>
  </div>
  <div class="form-group">
	<select name="lever" id="" class="form-control">
		<option value="">请选择客户等级</option>
        <option value="0">普通客户</option>
        <option value="1">大客户</option>
        <option value="2">重点开发客户</option>
        <option value="3">合作伙伴</option>
        <option value="4">战略合作伙伴</option>
	</select>
  </div>
<div class="form-group">
	<select name="lever" id="" class="form-control">	
		<option value="">请选择客户满意度</option>
        <option value="0">一星</option>
        <option value="1">二星</option>
        <option value="2">三星</option>
        <option value="2">四星</option>
        <option value="2">五星</option>
	</select>
</div>-->

  <input class="btn btn-default search" type="button" value="查询">
</form>
</div> 
<div id="container">
	
</div>

</div>
<style>
#customerConstitute{
	width: 1140px;
	overflow: hidden;
}
	.form-inline{
		margin-top: 15px;
		margin-left: 10px;
		margin-bottom: 20px;
	}
	.search{
		margin-left: 50px;
	}
	.table th,td{
		text-align: center;
	}
	#add{
		margin-left: 250px;
	}
	#toAdd{
		margin-top: 50px;
	}
	#deleteModal{
		margin-top: 100px;
	}
	#container{
		border: 1px solid #ccc;
		min-height:430px;
		width: 97%;
		margin: 10px;
		box-shadow: 10px 10px 5px #ccc;
	}
</style>
<script type="text/javascript">

	$(function(){
		$(".search").on("click",function(){
			var condit = $("select[name=condit] option:selected").val();
			var url = "reportForms/getCustConstitute";
			$.get(url,{condition:condit},function(data){
				draw(data);
			});
			
		});
	})
		function draw(data){
			var chart = Highcharts.chart('container', {
	chart: {
		type: 'column'
	},
	title: {
		text: '客户构成分析'
	},
	subtitle: {
		text: ''
	},
	xAxis: {
		type: 'category'
	},
	yAxis: {
		title: {
			text: ''
		}
	},
	legend: {
		enabled: false
	},
	plotOptions: {
		series: {
			borderWidth: 0,
			dataLabels: {
				enabled: true,
				format: '{point.y:.1f}%'
			}
		}
	},
	tooltip: {
		headerFormat: '<span style="font-size:11px">{series.name}</span><br>',
		pointFormat: '<span style="color:{point.color}">{point.name}</span>: <b>{point.y:.2f}%</b> of total<br/>'
	},
	series: [{
		name: '客户数量',
		colorByPoint: true,
		data: data
	}]
});
		}
</script>
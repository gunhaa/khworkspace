<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>대기오염 공공 데이터</title>
	</head>

	<body>

		<h1>실시간 대기오염 정보</h1>

		지역 :
		<select id="location">
			<option>서울</option>
			<option>부산</option>
			<option>대구</option>
		</select>

		<button id="btn1">해당 지역 대기오염정보</button>

		<table id="result1" border="1">
			<thead>
				<tr>
					<th>측정소명</th>
					<th>측정일시</th>
					<th>통합대기환경수치</th>
					<th>미세먼지농도</th>
					<th>아황산가스농도</th>
					<th>일산화탄소농도</th>
					<th>이산화질소농도</th>
					<th>오존농도</th>
				</tr>
			</thead>

			<tbody id="bd">

			</tbody>

		</table>
		<script src="https://code.jquery.com/jquery-3.7.1.min.js"
			integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
		<script>

			// document.querySelector("#btn1").addEventListener("click" , e=>{
			// 	console.log("hi");
			// });

			$("#btn1").click(function () {
				/*$.ajax({ // 응답 데이터를 json형식으로 받을 때
					url: "air",
					data: {
						"location": $("#location").val(),
					},
					success: function (data) {

						console.log(data);
						console.log(Array.isArray(data));
						let str;

						let value="";

						// for(let item of data){
						// 	console.log(item);
						// 	value+= "<tr>" 
						// 		+"<td>"+item.stationName+"</td>"
						// 		+"<td>"+item.dataTime+"</td>"
						// 		+"<td>"+item.khaiValue+"</td>"
						// 		+"<td>"+item.pm10Value+"</td>"
						// 		+"<td>"+item.so2Value+"</td>"
						// 		+"<td>"+item.o3Value+"</td>"
						// 		+"<td>"+item.no2Value+"</td>"
						// 		+"<td>"+item.coValue+"</td>"
						// 		+"</tr>"
						// }
						// document.querySelector("#bd").innerHTML=value;
						

						// for(item of data){
						
						// 	str += `<tr>
						// 		<td>${item.stationName}!</td>
						// 		<td>${item.dataTime}@</td>
						// 		<td>${item.khaiValue}#</td>
						// 		<td>${item.pm10Value}$</td>
						// 		<td>${item.so2Value}%</td>
						// 		<td>${item.o3Value}^</td>
						// 		<td>${item.coValue}&</td>
						// 		<td>${item.no2Value}*</td>
						// 	</tr>`;
						// }
						
						// document.querySelector("#bd").innerHTML=str;


						
						// for(item of data){
						// 	document.querySelector("#bd").insertAdjacentHTML("afterbegin",
						// 	 `<tr>
						// 			<td>${item.stationName}!</td>
						// 			<td>${item.dataTime}@</td>
						// 			<td>${item.khaiValue}#</td>
						// 			<td>${item.pm10Value}$</td>
						// 			<td>${item.so2Value}%</td>
						// 			<td>${item.o3Value}^</td>
						// 			<td>${item.coValue}&</td>
						// 			<td>${item.no2Value}*</td>
						// 		</tr>`)
						// }


						data.forEach(item => {
							console.log(item);
							document.querySelector("#bd").insertAdjacentHTML("afterbegin",
							 `<tr>
									<td>${"${item.stationName}"}</td>
									<td>\${item.dataTime}</td>
									<td>\${item.khaiValue}</td>
									<td>\${item.pm10Value}</td>
									<td>\${item.so2Value}</td>
									<td>\${item.o3Value}</td>
									<td>\${item.coValue}</td>
									<td>\${item.no2Value}</td>
								</tr>`)
						});



					},
					error: function () {
						console.log("통신 실패");
					}

				})
				*/

				// ------------------------------------------------------------------------------------
				// 응답 데이터를 xml 형식으로 받을 때

				$.ajax({
					url: "air",
					data: {
						"location": $("#location").val(),
					},
					success: function (result) {

						//console.log(result);

						//$('요소명').find(매개변수)
						// - 기준이 되는 요소의 하위 요소들 중 특정 요소를 찾을 때 사용
						// - html, xml은 같은 markup language이기 때문에 사용 가능

						//console.log($(result).find("item"))
						// xml 형식의 응답 데이터를 받았을 때
						// 1. 넘겨 받은 데이터를 $() 제이쿼리화 시킨 후
						//    응답 데이터 안에 실제 데이터가 담겨있는 요소 선택

						const itemArr = $(result).find("item");

						// 2. 반복문을 통해 실제 데이터가 담긴 요소들에 접근해서 동적으로 요소 만들기
						//console.log(itemArr);
						let value;
						itemArr.each(function (index, item) {

							//console.log(arguments[0] +"번째 : "+ arguments[1]);

							//console.log($(item).find("stationName").text());

							value += "<tr>"
								+ "<td>" + $(item).find("stationName").text() + "</td>"
								+ "<td>" + $(item).find("dataTime").text() + "</td>"
								+ "<td>" + $(item).find("khaiValue").text() + "</td>"
								+ "<td>" + $(item).find("pm10Value").text() + "</td>"
								+ "<td>" + $(item).find("so2Value").text() + "</td>"
								+ "<td>" + $(item).find("o3Value").text() + "</td>"
								+ "<td>" + $(item).find("coValue").text() + "</td>"
								+ "<td>" + $(item).find("no2Value").text() + "</td>"
								+ "</tr>"
						}

						);

						// 3. 동적으로 만들어낸 요소를 화면에 출력
						$("#result1 > tbody").html(value);

					},
					error: function () {

						console.log("통신 실패함");

					}
				})


			})

		</script>

		<hr>

		<h1>실시간 지진해일 긴급대피장소</h1>

		<button id="btn2">실시간 지진해일 대피소 정보</button>
		<br><br>

		<table border="1" id="result2">
			<thead>
				<tr>
					<th>시도명</th>
					<th>시군구명</th>
					<th>대피지구명</th>
					<th>대피장소명</th>
					<th>주소</th>
					<th>경도</th>
					<th>위도</th>
					<th>수용가능인원수</th>
					<th>대피소 분류명</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
		<script>
			$("#btn2").click(function () {
				$.ajax({
					url: "hail",
					data: {
						"hi": "hi"
					},
					success: function (res) {


						const rowArr = $(res).find("row");


						let value;
						rowArr.each(function (index, item) {

							//console.log(arguments[0] +"번째 : "+ arguments[1]);

							//console.log($(item).find("stationName").text());

							value += "<tr>"
								+ "<td>" + $(item).find("sido_name").text() + "</td>"
								+ "<td>" + $(item).find("sigungu_name").text() + "</td>"
								+ "<td>" + $(item).find("remarks").text() + "</td>"
								+ "<td>" + $(item).find("shel_nm").text() + "</td>"
								+ "<td>" + $(item).find("address").text() + "</td>"
								+ "<td>" + $(item).find("lon").text() + "</td>"
								+ "<td>" + $(item).find("lat").text() + "</td>"
								+ "<td>" + $(item).find("shel_av").text() + "</td>"
								+ "<td>" + $(item).find("shel_div_type").text() + "</td>"
								+ "</tr>"
						}

						);

						// 3. 동적으로 만들어낸 요소를 화면에 출력
						$("#result2 > tbody").html(value);

					},
					error: function () {
						console.log("지진 ajax오류임");
					}
				})
			})

		</script>

		<h1>한국전력거래소_계통한계가격 및 수요예측</h1>

		<button id="btn3">한국전력거래소 정보</button>
		<br><br>

		<table border="1" id="result3">
			<thead>
				<tr>
					<th>일시</th>
					<th>시간</th>
					<th>지역</th>
					<th>계통한계가격</th>
					<th>육지 예측수요</th>
					<th>제주 예측수요</th>
					<th>총 예측수요</th>
					<th>순번</th>
				</tr>
			</thead>
			<tbody id="tbr3">

			</tbody>
		</table>

		<script>
			$("#btn3").click(function(){

				$.ajax({

					url:"electric",
					data:{
						"HELLO" : "HI"
					},
					success: function(res){
						console.log(res);
						console.log(typeof res);
						console.log(res.response.body.items);
						//console.log(res.body.items);
						res.response.body.items.item.forEach(item => {
							document.querySelector("#tbr3").insertAdjacentHTML("beforeend",
							`<tr>
								<th>\${item.date}</th>
								<th>\${item.hour}</th>
								<th>\${item.areaName}</th>
								<th>\${item.slfd}</th>
								<th>\${item.mlfd}</th>
								<th>\${item.jlfd}</th>
								<th>\${item.smp}</th>
								<th>\${item.rn}</th>
							</tr>`
						)
						});
					},
					error:function(){
						console.log("전력공사 오류났음");
					}

				})
			});
		</script>


	</body>

	</html>
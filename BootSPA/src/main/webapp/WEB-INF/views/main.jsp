<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
<script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
<script src="https://unpkg.com/@babel/standalone/babel.min.js"></script>
<style>
	#wrapper {
		margin:auto;
		overflow:hidden;
		height:700px
	}
	
	#input-area{
		width:20%;
		background:yellow;
		height:100% ;
		float:left;
	}
	
	
	#list-area{
		width:60%;
		background:skyblue;
		height:100% ;
		float:left;
		overflow: scroll;
	}
	
	#detail-area{
		width:20%;
		background:orange;
		height:100% ;
		float:left;
	}
	
	#input-area input, #detail-area input{
		width:97%;
		
	}
	
	
	

</style>

<!-- <script type="text/javascript">-->
 <script type="text/babel">

// 동기 방식의 폼 전송
function regist() {
	$("#input-form").attr({
		action:"/board/regist",
		method:"post"
	})
	$("#input-form").submit();
}

// 비동기 방식의 기존 폼을 이용한 Parameter 전송
function registBySerial() {
	var params = $("#input-form").serialize();
	console.log(params);
	
	// 이미 전송할 파라미터화가 완료되었으므로, json으로 변환하지 말고 그냥 보내자
	$.ajax({
		url:"/rest/serial/board",
		type:"post",
		data:params,
		contentType:"application/x-www-form-urlencoded;charset=utf-8",
		success:function(result, status, xhr) {
			getList();
		},
		error:function(xhr, status, error) {
			alert(error);
		}
	})
}


// 비동기 방식의 기존 폼을 이용한 Json 문자열 전송
function registByJson() {
	var formArray =  $("#input-form").serializeArray();
	console.log(formArray);
	
	// 우리가 원하는 형태의 json으로 가공해보자
	var json={};
	for(var i = 0; i < formArray.length; i++) {
		json[formArray[i].name] = formArray[i].value;
	}
	
	console.log(json);
	
	$.ajax({
		url:"/rest/json/board",
		type:"post",
		data:JSON.stringify(json),
		contentType:"application/json;charset=utf-8",
		success:function(result, status, xhr) {
			getList();
		},
		error:function(xhr, status, error) {
			alert(error.msg);
		}
	})
	
}
//====================================================
function getList() {
	$.ajax({
		url:"/rest/board",
		type:"get",
		success:function(result) {
			console.log("서버로부터 받은 json 목록 : ", result);
					
		printList(result);
			
		}
	})
	
}

function getDetail(board_id) {
	alert("넘겨받은 board_id : " + board_id);
	
	$.ajax({
		url:"/rest/board/"+board_id,
		type:"get",
		success:function(result, status, xhr) {
			printBoard(result);
			console.log(result);
		}
		
	})

}
// 우측 영역에 폼 한 건 출력
function printBoard(board) {
	$("#detail-form input[name='board_id']").val(board.board_id);
	$("#detail-form input[name='title']").val(board.title);
	$("#detail-form input[name='writer']").val(board.writer);
	$("#detail-form textarea[name='content']").val(board.content);
	
}





function Row(props) {
	
	var link = "javascript:getDetail("+props.board_id+")";
	
	return (
		<tr align="center">
			<td>{props.board_id}</td>
			<td><a href={link}>{props.title}</a></td>
			<td>{props.writer}</td>
			<td>{props.regdate}</td>
			<td>{props.hit}</td>
		</tr>
	
	);

}




function BoardTable(props) {
	
	var list = props.boardList;

	var tag=[];		// 여기에 tr을 모아놓은다

	for(var i = 0; i < list.length; i++) {
		var obj = list[i];
		tag.push(<Row board_id={obj.board_id} title={obj.title} writer={obj.writer} regdate={obj.regdate} hit={obj.hit} />);		// arraylist.add()와 동일
	}

	return (
			<table width="100%" border="1px">
				<thead>
					<tr>
						<th>No</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
					{tag}				
				</tbody>
		</table>
	
	);
}

function printList(jsonArray) {
	var root = ReactDOM.createRoot(document.getElementById("list-area"));
	root.render(<BoardTable boardList={jsonArray} />);
}


	$(function () {
		$($("#input-area button")[0]).click(function() {
			regist();
		})
	})
	
	
	$(function () {
		$($("#input-area button")[1]).click(function() {
			registBySerial();
		})
	})
	
function del() {
		if(confirm("삭제하시겠어요?")) {
			$.ajax({
				url:"/rest/board?board_id="+$("#detail-form input[name='board_id']").val(),
				type:"delete",
				success:function(result, status, xhr) {
					console.log(result);
					getList();
				}
				
			})
		
		
	}

}
	
	
function edit() {
		
		var params = $("#detail-form").serialize();
		
		
		if(confirm("수정하시겠어요?")) {
			$.ajax({
				url:"/rest/board",
				type:"put",
				data:params,
				contentType:"application/x-www-form-urlencoded; chaset=utf-8",
				success:function(result, status, xhr) {
					console.log(result);
					getList();
				}
				
			})
		
		
	}

}
	
	
	
	$(function () {
		$($("#input-area button")[2]).click(function() {
			registByJson();
		})


		$($("#detail-area button")[0]).click(function() {
			edit();
		})


		$($("#detail-area button")[1]).click(function() {
			del();
		})

		getList();
	})


</script>
<body>
나의 게시판 메인 페이지

	<div id="wrapper" >
		<div id="input-area">
			 <form id="input-form">
				<input type="text" name="title">
				<input type="text" name="writer">
				<textarea style="width:98%; height:150px;" name="content"></textarea>
				<button type="button">일반 등록</button>
				<button type="button">폼시리얼 등록</button>
				<button type="button">Json 전송</button>
			</form>			
		</div>
		
		<div id="list-area">
			
		</div>
		
		<div id="detail-area">
			<form id="detail-form">
				<input type="hidden" name="board_id">
				<input type="text" name="title">
				<input type="text" name="writer">
				<textarea style="width:98%; height:150px;" name="content"></textarea>
				<button type="button">수정</button>
				<button type="button">삭제</button>
			</form>			
		</div>
	</div>


</body>
</html>
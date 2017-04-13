<?php

	require_once ('Connect.php');
	
	//connection to db
	$db = new Connect();
	$Conn = $db->connect();
	
	$response = array(); //response
	
	//isset function is applicable for variable is set or not
	if(isset($_POST['date']) && isset($_POST['atstatus']) && isset($_POST['atdiv'])) {
		
		$date = $_POST['date'];
		$atstatus = $_POST['atstatus'];
		$atdiv = $_POST['atdiv'];

		
		$sql = "SELECT atstatus As Status, COUNT(atstatus) AS Total FROM attendance WHERE atdiv = '".$atdiv."' and atstatus = '".$atstatus."' and atdate = '".$date."' GROUP by atstatus";
		
		$res = mysqli_query($Conn,$sql); //query in the table;
		while($row = mysqli_fetch_array($res)){
			array_push($response, array(
				"Status" =>$row['Status'],
				"Total"=>$row['Total']));//storing data in array;
		}
		echo json_encode($response);
		mysqli_close($Conn);
	}else{
		//Invalid approach 
		$response["error"] = TRUE;
		$response["error_msg"] = "Invalid approach!";
		echo json_encode($response);
	}

?>
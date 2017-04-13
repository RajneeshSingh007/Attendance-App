<?php

	require_once ('Connect.php');
	
	//connection to db
	$db = new Connect();
	$Conn = $db->connect();
	
	$response = array(); //response
	
	//isset function is applicable for variable is set or not
	if(isset($_POST['tablename']) && isset($_POST['startdate']) && isset($_POST['enddate']) && isset($_POST['lect']) && isset($_POST['atdiv']) && isset($_POST['atstatus'])) {
		
		$tablename = $_POST['tablename'];
		$startdate = $_POST['startdate'];
		$enddate = $_POST['enddate'];
		$lect = $_POST['lect'];
		$atstatus = $_POST['atstatus'];
		$atdiv = $_POST['atdiv'];
	
		
		$sql = "SELECT atrollno, COUNT(*) AS Total, ((COUNT(*) / $lect) * 100) AS 'Percentage' From $tablename WHERE atstatus = '".$atstatus."' AND atdiv = '".$atdiv."' AND atdate BETWEEN '".$startdate."' and '".$enddate."' GROUP BY atrollno ORDER BY atrollno ASC";
		
		$res = mysqli_query($Conn,$sql); //query in the table;
		while($row = mysqli_fetch_array($res)){
			array_push($response, array(
				"Rollno" =>$row['atrollno'],
				"Total"=>$row['Total'],
				"Percentage" => $row['Percentage']));//storing data in array;
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
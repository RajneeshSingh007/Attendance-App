<?php

	require_once ('DB_Functions.php');
	
	//connection to db and constructor of function class
	$db = new DB_Functions();
	
	$response = array("error" => false);
	
	if(isset($_POST['username']) && isset($_POST['password'])) {
		
		//got details
		$username = $_POST['username'];
		$password = $_POST['password'];
		if(!$db->checkifuserexisted($username)){
			$response["error"] = TRUE;
			$response["error_msg"] = "Username not found";
			echo json_encode($response);
		}else{
			$user = $db->getuserData($username, $password); // get username & password
			if($user != false){
				$response["error"] = FALSE;
				$response["user"]["username"] = $user["username"];
				echo json_encode($response); //change into json format
			}else{
				// user is not found with the credentials
				$response["error"] = TRUE;
				$response["error_msg"] = "Login credentials are wrong. Please try again!";
				echo json_encode($response);
			}
		}
	
	}else{
		// required post params is missing
		$response["error"] = TRUE;
		$response["error_msg"] = "Required parameters is missing!";
		echo json_encode($response);
	}
	
?>
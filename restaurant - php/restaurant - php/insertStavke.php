<?php
$response = array();
//include 'db/db_connect.php';
//include 'functions.php';

$servername = "localhost";
$username = "root";
$password = "";
$dbname = "restaurant";

// Create connection
$con = mysqli_connect($servername,$username,$password,$dbname);

// Check connection
if(mysqli_connect_errno())
{
	echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

//Get the input request parameters
$inputJSON = file_get_contents('php://input');
$input = json_decode($inputJSON, TRUE); //convert JSON into array

//Check for Mandatory parameters
if(isset($input['strorderitem'])){
	$strorderitem = $input['strorderitem'];
	

	
	
	//Check if user already exist
//	if(!userExists($menu_item)){

		//Get a unique Salt
		//$salt         = getSalt();
		
		//Generate a unique password Hash
		//$passwordHash = password_hash(concatPasswordWithSalt($password,$salt),PASSWORD_DEFAULT);
		
		//Query to register new user
		$insertOrder  = "INSERT INTO orderitem(orderdetail) VALUES (?)";
		if($stmt = $con->prepare($insertOrder)){
			$stmt->bind_param("s",$strorderitem);
			$stmt->execute();
			$response["status"] = 0;
			$response["message"] = "Menu item added";
			$stmt->close();
		}

}
else{
	$response["status"] = 1;
	$response["message"] = "Missing mandatory parameters";
}
echo json_encode($response);
?>
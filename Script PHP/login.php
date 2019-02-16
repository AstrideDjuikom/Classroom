<?php

if ($_SERVER['REQUEST_METHOD']=='POST') {

    $lname = $_POST['lname'];
    $password = $_POST['password'];

    require_once 'lib.php';
    include('check.php');
    include('checkAttending.php');
    

    $sql = "SELECT * FROM friend WHERE last_name='$last_name' ";

    $response = mysqli_query($conn, $sql);

    $result = array();
    $result['login'] = array();
    
    if ( mysqli_num_rows($response) === 1 ) {
        
        $row = mysqli_fetch_assoc($response);

        if ( password_verify($password, $row['password']) ) {
            
            $index['fname'] = $row['fname'];
            $index['id'] = $row['id'];

            array_push($result['login'], $index);

            $result['success'] = "1";
            $result['message'] = "success";
            echo json_encode($result);

            mysqli_close($conn);

        } else {

            $result['success'] = "0";
            $result['message'] = "error";
            echo json_encode($result);

            mysqli_close($conn);

        }

    }

}

?>
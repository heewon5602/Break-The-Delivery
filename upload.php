<?php
    if ($_SERVER['REQUEST_METHOD'] == 'POST')
    {
        $id = $_POST['id'];
        $photo = $_POST['photo'];
    
        $path = "uploads/$id.jpeg";
        $finalPath = "http://moblieigroup.dothome.co.kr/android_register_login/".$path;
    
        require_once 'volley_connect.php';
    
        $sql = "UPDATE users_table SET photo = '$finalPath' WHERE id = '$id'";
    
        if (mysqli_query($conn, $sql))
        {
            if (file_put_contents($path, base64_decode($photo)))
            {
                $result['success'] = "1";
                $result['message'] = "success";
    
                echo json_encode($result);
                mysqli_close($conn);
            }
        }
    }
?>
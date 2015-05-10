  <?php
// array for JSON response
$response = array();
// check for required fields
if (isset($_GET['akses'])) {
    $akses = $_GET['akses'];
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    // connecting to db
    $db = new DB_CONNECT();
    // mysql inserting a new row

    if ($akses == "admin") {
        $result = mysql_query("SELECT * FROM siswa");
        // check if row inserted or not
        if (mysql_num_rows($result) > 0) {
            // looping through all results
            // products node
            $response["siswa"] = array();
            while ($row = mysql_fetch_array($result)) {
                // temp user array
                $permintaan = array();
                    $permintaan["nis"] = $row["nis"];
                    $permintaan["kd_kls"] = $row["kd_kls"];
                    $permintaan["nm_siswa"] = $row["nm_siswa"];
                    $permintaan["almt_siswa"] = $row["almt_siswa"];
                    $permintaan["tgl_lhr_siswa"] = $row["tgl_lhr_siswa"];
                    $permintaan["temp_lhr_siswa"] = $row["temp_lhr_siswa"];
                    $permintaan["jns_klmn_siswa"] = $row["jns_klmn_siswa"];
                    $permintaan["agm_siswa"] = $row["agm_siswa"];
                    $permintaan["tlp_siswa"] = $row["tlp_siswa"];
                    $permintaan["kls"] = $row["kls"];
                // push single product into final response array
                array_push($response["siswa"], $permintaan);
            }
            // success
            // echoing JSON response
            // $response["siswa"] = $response  ;
            $oke["d"] = $response;
            echo json_encode($oke);

            // echo json_encode($response);
        } else {
            $response["reason"] = "(1) oops! tidak ada siswa !";
            $oke["e"] = $response;
            echo json_encode($oke);
        }
    }else {
        $response["reason"] = "(3) oops! akses ditolak !";
        $oke["e"] = $response;
        echo json_encode($oke);
    }
    
} else {
    $response["reason"] = "(2) oops! ada yang salah !";
    $oke["e"] = $response;
    echo json_encode($oke);
}
?>
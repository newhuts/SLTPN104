  <?php
// array for JSON response
$response = array();
// check for required fields
if (isset($_POST['nis']) && isset($_POST['nm_siswa'])) { 
    $nis = $_POST['nis'];
    $kd_kls = $_POST['kd_kls'];
    $nm_siswa = $_POST['nm_siswa'];
    $almt_siswa = $_POST['almt_siswa'];
    $tgl_lhr_siswa = $_POST['tgl_lhr_siswa'];
    $temp_lhr_siswa = $_POST['temp_lhr_siswa'];
    $jns_klmn_siswa = $_POST['jns_klmn_siswa'];
    $agm_siswa = $_POST['agm_siswa'];
    $tlp_siswa = $_POST['tlp_siswa'];
    $kls = $_POST['kls'];
    // include db connect class
    require_once __DIR__ . '/db_connect.php';
    // connecting to db
    $db = new DB_CONNECT();
    // mysql inserting a new row
    $result = mysql_query("INSERT INTO siswa(nis, kd_kls, nm_siswa, almt_siswa, tgl_lhr_siswa, temp_lhr_siswa, jns_klmn_siswa, agm_siswa, tlp_siswa, kls) VALUES ('$nis', '$kd_kls','$nm_siswa', '$almt_siswa', '$tgl_lhr_siswa', '$temp_lhr_siswa', '$jns_klmn_siswa', '$agm_siswa', '$tlp_siswa', '$kls') ");
    // check if row inserted or not
    if ($result) {
        $response["status"] = "input siswa $nm_siswa berhasil ";
        $oke["d"] = $response;
        echo json_encode($oke);
    } else {
        $response["reason"] = "(1) oops! ada yang salah !";
        $oke["e"] = $response;
        echo json_encode($oke);
    }
} else {
    $response["reason"] = "(2) oops! ada yang salah !";
    $oke["e"] = $response;
    echo json_encode($oke);
}
?>
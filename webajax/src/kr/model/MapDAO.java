package kr.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MapDAO {
	public String getMaps(String addr) {
		//Kakao Open API URL (주소 알아야함)
		//서버와연결해서 어떻게 json을 받아오는지!
		String url = "https://dapi.kakao.com/v2/local/search/address.json";
		String apiKey = "KakaoAK f32c4bf159dc4de1538954070d8b564e";
		StringBuffer json = new StringBuffer();
		try {
			String query = "query="+URLEncoder.encode(addr, "UTF-8"); 	//"query"에 addr넘겨야하기에 이름바꾸면안됨(url에서 읽어들이는 parameter이름인 query)
			// https://dapi.kakao.com/v2/local/search/address.json?query=광주광역시어쩌구저쩌구~~
			StringBuffer sb = new StringBuffer(); //url뒤에 get방식 완성시켜주는!
			sb.append(url);
			sb.append("?");
			sb.append(query);
			
			URL u = new URL(sb.toString()); //URL이라는 network api 써야함 
			HttpURLConnection conn = (HttpURLConnection) u.openConnection(); //downCasting //kakao와 연결됨
			conn.setRequestProperty("Authorization", apiKey);
			conn.setRequestMethod("GET");
			//★서버로부터 응답되는 데이터를 받아야한다.★ -(conn을 통해서)
			//서로 성격이 다른 아래 빨대들. 바로is못쓰고 InputStreamReader필요
//			InputStream is = conn.getInputStream(); //(입력스트림-입력빨대)
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); //(InputStream만 쓰면 '한글'인코딩이 깨지기 때문에 쓰는 다른빨대)
			String line;
			//StringBuffer json = new StringBuffer(); //try문밖으로
			while((line=br.readLine())!=null) { //서버의 한 줄을 읽어와서(.readLine()) line에 넣어줌   //null이아니다==계속 읽어들일 데이터가 있다는 뜻
				json.append(line); 	//{  }
			}
			if(0<json.toString().length()) { //데이터가 들어있다!
				System.out.println("json:"+json.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return json.toString(); //받아놓은 json데이터를 반환
		
	}
}

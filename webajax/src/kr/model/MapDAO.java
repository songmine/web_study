package kr.model;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MapDAO {
	public String getMaps(String addr) {
		//Kakao Open API URL (�ּ� �˾ƾ���)
		//�����Ϳ����ؼ� ��� json�� �޾ƿ�����!
		String url = "https://dapi.kakao.com/v2/local/search/address.json";
		String apiKey = "KakaoAK f32c4bf159dc4de1538954070d8b564e";
		StringBuffer json = new StringBuffer();
		try {
			String query = "query="+URLEncoder.encode(addr, "UTF-8"); 	//"query"�� addr�Ѱܾ��ϱ⿡ �̸��ٲٸ�ȵ�(url���� �о���̴� parameter�̸��� query)
			// https://dapi.kakao.com/v2/local/search/address.json?query=���ֱ����þ�¼����¼��~~
			StringBuffer sb = new StringBuffer(); //url�ڿ� get��� �ϼ������ִ�!
			sb.append(url);
			sb.append("?");
			sb.append(query);
			
			URL u = new URL(sb.toString()); //URL�̶�� network api ����� 
			HttpURLConnection conn = (HttpURLConnection) u.openConnection(); //downCasting //kakao�� �����
			conn.setRequestProperty("Authorization", apiKey);
			conn.setRequestMethod("GET");
			//�ڼ����κ��� ����Ǵ� �����͸� �޾ƾ��Ѵ�.�� -(conn�� ���ؼ�)
			//���� ������ �ٸ� �Ʒ� �����. �ٷ�is������ InputStreamReader�ʿ�
//			InputStream is = conn.getInputStream(); //(�Է½�Ʈ��-�Է»���)
			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8")); //(InputStream�� ���� '�ѱ�'���ڵ��� ������ ������ ���� �ٸ�����)
			String line;
			//StringBuffer json = new StringBuffer(); //try��������
			while((line=br.readLine())!=null) { //������ �� ���� �о�ͼ�(.readLine()) line�� �־���   //null�̾ƴϴ�==��� �о���� �����Ͱ� �ִٴ� ��
				json.append(line); 	//{  }
			}
			if(0<json.toString().length()) { //�����Ͱ� ����ִ�!
				System.out.println("json:"+json.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return json.toString(); //�޾Ƴ��� json�����͸� ��ȯ
		
	}
}

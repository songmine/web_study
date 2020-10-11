package kr.mem.controller;

import java.util.HashMap;

import kr.mem.pojo.Controller;
import kr.mem.pojo.*;

public class HandlerMapping {
	//		Key(/list.do), Value(MemberListController)
	private HashMap<String, Controller> mappings;
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		initMap();
	}

	// �ڡڡڡڡڡڡڡ�  MVC STEP2�ڡڡڡڡڡڡڡ� Ŭ����Ʈ�� ��û�޾Ƽ� ���� ���������� �ڡڡڡڡڡڡڡ�
	private void initMap() {
		try {
			mappings.put("/list.do", new MemberListController()); //��ü�� ������ new�� ��ü���� �� �־�� ��
			mappings.put("/insert.do", new MemberInsertController()); 
			mappings.put("/insertForm.do", new MemberInsertFormController()); 
			mappings.put("/delete.do", new MemberDeleteController()); 
			mappings.put("/content.do", new MemberContentController()); 
			mappings.put("/update.do", new MemberUpdateController());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public Controller getController(String key) {
		return mappings.get(key);
	}


}

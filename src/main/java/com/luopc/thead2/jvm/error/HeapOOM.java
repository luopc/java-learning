package com.luopc.thead2.jvm.error;

import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
	
	static class OOMObject {
    }

    public static void main(String[] args) {
        List<UserBean> users = new ArrayList<UserBean>();
        while (true) {
            users.add(new UserBean());
        }
    }

}

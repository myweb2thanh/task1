package com.example.task1.service;

import com.example.task1.model.MemberInfo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MemberService {

    private final Map<String, MemberInfo> memberMap = new HashMap<>();

    public MemberService() {
        memberMap.put("son", new MemberInfo("Ngô Văn Sơn", 21, "Dai Hoc Dong A", 2004));
        memberMap.put("thanh", new MemberInfo("Nguyễn Xuân Thành", 21, "Dai Hoc Dong A ", 2004));
    }

    public MemberInfo getMemberByName(String name) {
        return memberMap.get(name);
    }
}


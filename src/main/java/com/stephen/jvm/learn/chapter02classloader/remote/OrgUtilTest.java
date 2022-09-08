package com.stephen.jvm.learn.chapter02classloader.remote;

import com.nari.resource.pojo.dto.system.OrgTreeDTO;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;

public class OrgUtilTest {

    public List<OrgTreeDTO> invokeMethod(String className,String methodName,String returnClass,String paramsClass[],Object... args) throws Throwable {
        Class cClass = Class.forName(className);
        Class cReturnClass = Class.forName(returnClass);
        MethodType methodType=null;
        if(paramsClass!=null){
            Class[] cParamsClass=new Class[paramsClass.length];
            for(int i=0;i< paramsClass.length;i++){
                Class cParamClass=Class.forName(paramsClass[i]);
                cParamsClass[i]=cParamClass;
            }
            methodType=MethodType.methodType(cReturnClass,cParamsClass);
        }else {
            methodType=MethodType.methodType(cReturnClass);
        }
        MethodHandle methodHandle= MethodHandles.lookup().findStatic(cClass,methodName,methodType);
        List<OrgTreeDTO> o = (List<OrgTreeDTO>)methodHandle.invoke(args);
        return o;
    }

    public static void main(String[] args) {
        OrgUtilTest orgUtilTest=new OrgUtilTest();
        try {
            List<OrgTreeDTO> getOrgTreeDTOS = orgUtilTest.invokeMethod("com.nari.resource.util.OrgUtil",
                    "getOrgTreeDTOS", "java.util.List", null, null);
            System.out.println(getOrgTreeDTOS);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}

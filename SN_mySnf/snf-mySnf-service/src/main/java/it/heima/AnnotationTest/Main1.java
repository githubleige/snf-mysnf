package it.heima.AnnotationTest;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        Class serviceImplClass=MonitorStandardQueryRsfServiceImpl.class;
        List<Implement> implementList = parseImplements(serviceImplClass);

    }


    public static List<Implement> parseImplements(Class clz) {
        List<Implement> result = new ArrayList();
        Annotation[] annotations = clz.getDeclaredAnnotations();
        if (annotations != null && annotations.length != 0) {
            Annotation[] arr$ = annotations;
            int len$ = annotations.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Annotation annotation = arr$[i$];
                if (annotation instanceof Implements) {
                    Implement[] values = ((Implements)annotation).value();
                    if (values != null && values.length != 0) {
                        Collections.addAll(result, values);
                    }
                } else if (annotation instanceof Implement) {
                    result.add((Implement)annotation);
                }
            }

            return result;
        } else {
            return result;
        }
    }
}



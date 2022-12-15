package com.gooks.blacklabel.common.aop.custom;

import com.fasterxml.jackson.databind.introspect.Annotated;
import com.fasterxml.jackson.databind.introspect.NopAnnotationIntrospector;
import com.gooks.blacklabel.common.aop.custom.annotation.MaskLogs;

public class MaskLogsAnnotationIntrospector extends NopAnnotationIntrospector {
    private static final long serialVersionUID = 1L;

    @Override
    public Object findSerializer(Annotated am) {
        MaskLogs maskLogs = am.getAnnotation(MaskLogs.class);
        if (maskLogs != null) {
            return MaskLogsSerializer.class;
        }
        return null;
    }
}

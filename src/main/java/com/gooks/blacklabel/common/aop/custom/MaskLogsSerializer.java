package com.gooks.blacklabel.common.aop.custom;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.gooks.blacklabel.common.aop.custom.annotation.MaskLogs;

import java.io.IOException;

public class MaskLogsSerializer extends StdSerializer<String> implements ContextualSerializer {

    private static final long serialVersionUID = 1L;

    private String maskValue;

    public MaskLogsSerializer() {
        super(String.class);
    }

    public MaskLogsSerializer(String maskValue) {
        super(String.class);
        this.maskValue = maskValue;
    }

    @Override
    public void serialize(String value, JsonGenerator jsonGenerator, SerializerProvider provider) throws IOException {
        jsonGenerator.writeString(maskValue);
    }

    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        String maskValue = null;
        MaskLogs maskLogs = null;
        if (beanProperty != null) {
            maskLogs = beanProperty.getAnnotation(MaskLogs.class);
        }
        if (maskLogs != null) {
            maskValue = maskLogs.value();
        }
        return new MaskLogsSerializer(maskValue);
    }
}

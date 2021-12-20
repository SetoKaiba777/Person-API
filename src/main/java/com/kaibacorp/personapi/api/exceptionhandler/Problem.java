package com.kaibacorp.personapi.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
public class Problem {
    private Integer status;
    private OffsetDateTime dateHour;
    private String title;
    private List<Field> fields;

    public Problem() {

    }

    @Getter
    @Setter
    public static class Field{
        private String name;
        private String msg;

        public Field(String name, String msg){
            super();
            this.name=name;
            this.msg=msg;

        }
    }
}

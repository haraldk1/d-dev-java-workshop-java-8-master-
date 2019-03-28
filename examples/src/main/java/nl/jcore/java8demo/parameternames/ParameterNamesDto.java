package nl.jcore.java8demo.parameternames;

import com.fasterxml.jackson.annotation.JsonCreator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

public class ParameterNamesDto {
    private class ParameterReflectionDto {
        private final int id;
        private final String name;

        @JsonCreator
        public ParameterReflectionDto(final int id, final String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }

    @RestController
    @RequestMapping("/api/1/demo/parameter-names/dto")
    public class ParameterReflectionController {
        @RequestMapping
        public void demo(final ParameterReflectionDto dto) {
        }
    }
}


package common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public interface Common {
    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * desc: jsonString
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    default String toJsonString(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    /**
     * desc: 控制台输出
     *
     * @param object
     * @return
     * @throws JsonProcessingException
     */
    default String toJsonStringAndSout(Object object) throws JsonProcessingException {
        String jsonString = this.toJsonString(object);
        System.out.println(jsonString);
        return jsonString;
    }

}

package hammertank.jackson.generictype;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import java.util.Collections;
import java.util.List;

public class GenericTypeDeserialize {

    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeFactory factory = mapper.getTypeFactory();

        Person person = new Person();
        person.setAge(29);
        person.setName("Jack");

        // Deserialize Collection
        List<Person> list = Collections.singletonList(person);
        String jsonStr = mapper.writeValueAsString(list);

        JavaType collectionType = factory.constructCollectionType(List.class, Person.class);
        List<Person> deserializedList = mapper.readValue(
                jsonStr,
                new TypeReference<List<Person>>() {
                });

        // Deserialize GenericType
        HttpResponse<Person> response = new HttpResponse<>();
        response.setCode(200);
        response.setData(person);
        jsonStr = mapper.writeValueAsString(response);

        HttpResponse<Person> deserialized = mapper.readValue(jsonStr, new TypeReference<HttpResponse<Person>>() {
        });
    }
}

# Jackson Tricks

## Deserialize Generic Type
See [GenericTypeDeserialize.java](src/main/java/hammertank/jackson/generictype/GenericTypeDeserialize.java)
## Serialize/Deserialize Subclasses 
Serialize/Deserialize subclasses in 3 manners:
  
1. [JsonTypeInfo.As.EXISTING_PROPERTY](src/main/java/hammertank/jackson/inherit/UseExistingProperty.java)
2. [JsonTypeInfo.As.PROPERTY](src/main/java/hammertank/jackson/inherit/AppendExtraProperty.java)
3. [JsonTypeInfo.As.EXTERNAL_PROPERTY](src/main/java/hammertank/jackson/inherit/UseExternalProperty.java)

Note:
* Can not append type property when serializing Java collections directly due to java Collection's type erasing. There is a [PR](https://github.com/FasterXML/jackson-databind/issues/1308) on GitHub. 
* JsonTypeInfo.As.EXTERNAL_PROPERTY can not be used for container values (arrays, Java Collections); it only works for scalar and POJO values.

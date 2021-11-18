package com.baeldung.um.client.marshall;

import com.baeldung.client.marshall.IMarshaller;
import com.baeldung.um.persistence.model.Privilege;
import com.baeldung.um.persistence.model.Role;
import com.baeldung.um.persistence.model.User;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;

public final class JacksonMarshaller implements IMarshaller {
    private final Logger logger = LoggerFactory.getLogger(JacksonMarshaller.class);

    private final ObjectMapper objectMapper;

    public JacksonMarshaller() {
        super();

        objectMapper = new ObjectMapper();
    }

    // API

    @Override
    public final <T> String encode(final T resource) {
        Preconditions.checkNotNull(resource);
        String entityAsJSON = null;
        try {
            entityAsJSON = objectMapper.writeValueAsString(resource);
        } catch (final JsonParseException parseEx) {
            logger.error("", parseEx);
        } catch (final JsonMappingException mappingEx) {
            logger.error("", mappingEx);
        } catch (final IOException ioEx) {
            logger.error("", ioEx);
        }

        return entityAsJSON;
    }

    @Override
    public final <T> T decode(final String resourceAsString, final Class<T> clazz) {
        Preconditions.checkNotNull(resourceAsString);

        T entity = null;
        try {
            entity = objectMapper.readValue(resourceAsString, clazz);
        } catch (final JsonParseException parseEx) {
            logger.error("", parseEx);
        } catch (final JsonMappingException mappingEx) {
            logger.error("", mappingEx);
        } catch (final IOException ioEx) {
            logger.error("", ioEx);
        }

        return entity;
    }

    @SuppressWarnings("unchecked")
    @Override
    public final <T> List<T> decodeList(final String resourcesAsString, final Class<T> clazz) {
        Preconditions.checkNotNull(resourcesAsString);

        List<T> entities = null;
        try {
            if (clazz.equals(Role.class)) {
                entities = objectMapper.readValue(resourcesAsString, new TypeReference<List<Role>>() {
                    // ...
                });
            } else if (clazz.equals(Privilege.class)) {
                entities = objectMapper.readValue(resourcesAsString, new TypeReference<List<Privilege>>() {
                    // ...
                });
            } else if (clazz.equals(User.class)) {
                entities = objectMapper.readValue(resourcesAsString, new TypeReference<List<User>>() {
                    // ...
                });
            } else if (clazz.equals(User.class)) {
                entities = objectMapper.readValue(resourcesAsString, new TypeReference<List<User>>() {
                    // ...
                });
            } else {
                entities = objectMapper.readValue(resourcesAsString, List.class);
            }
        } catch (final JsonParseException parseEx) {
            logger.error("", parseEx);
        } catch (final JsonMappingException mappingEx) {
            logger.error("", mappingEx);
        } catch (final IOException ioEx) {
            logger.error("", ioEx);
        }

        return entities;
    }

    @Override
    public final String getMime() {
        return MediaType.APPLICATION_JSON.toString();
    }

}

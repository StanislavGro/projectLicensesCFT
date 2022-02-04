package ru.cft.yellowrubberduck;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.cft.yellowrubberduck.exception.InvalidFileException;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;

@Configuration
@EnableAutoConfiguration
public class YellowRubberDuckConfiguration {
    private static final String KEY_TYPE = "RSA";

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.addConverter(new Converter<Instant, Long>() {//lambda doesn't work for unknown reason
            @Override
            public Long convert(final MappingContext<Instant, Long> context) {
                return context.getSource().getEpochSecond();
            }
        });
        modelMapper.addConverter(new Converter<Long, Instant>() {
            @Override
            public Instant convert(final MappingContext<Long, Instant> context) {
                return Instant.ofEpochSecond(context.getSource());
            }
        });
        modelMapper.addConverter(new Converter<PublicKey, byte[]>() {
            @Override
            public byte[] convert(final MappingContext<PublicKey, byte[]> context) {
                return context.getSource().getEncoded();
            }
        });
        modelMapper.addConverter(new Converter<byte[], PublicKey>() {
            @Override
            public PublicKey convert(final MappingContext<byte[], PublicKey> context) {
                try {
                    KeyFactory keyFactory = KeyFactory.getInstance(KEY_TYPE);
                    KeySpec keySpecX509 = new X509EncodedKeySpec(context.getSource());
                    return keyFactory.generatePublic(keySpecX509);
                } catch (NoSuchAlgorithmException e) {
                    throw new RuntimeException(e);
                } catch (InvalidKeySpecException e) {
                    throw new InvalidFileException(e);
                }
            }
        });
        return modelMapper;
    }
}

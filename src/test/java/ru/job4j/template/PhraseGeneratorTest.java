package ru.job4j.template;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;

@Disabled
public class PhraseGeneratorTest {

    @Test
    void generationIsCorrect() {
        PhraseGenerator gen = new PhraseGenerator();
        String template = "";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Dima");
        args.put("subject", "employee");
        assertThat(gen.produce(template, args)).isEqualTo("");
    }

    @Test
    void mapHaveJustOneKey() {
        PhraseGenerator gen = new PhraseGenerator();
        String template = "";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Dima");
        assertThatThrownBy(() -> gen.produce(template, args)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void mapHasExtraKeys() {
        PhraseGenerator gen = new PhraseGenerator();
        String template = "";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Dima");
        args.put("subject", "employee");
        args.put("flat", "3");
        args.put("Town", "Tyla");
        assertThatThrownBy(() -> gen.produce(template, args)).
                isInstanceOf(IllegalArgumentException.class);
    }

}
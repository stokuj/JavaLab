
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import org.junit.platform.commons.util.StringUtils;

/**
 *
 * @author Gall Anonim
 */
public class NewEmptyJUnitTest {

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab"}) // add "" 
    void aaaa(String candidate) {
        assertTrue(StringUtils.isNotBlank(candidate), "String is empty!");
    }

}

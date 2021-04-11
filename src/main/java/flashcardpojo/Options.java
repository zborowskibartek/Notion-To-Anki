package flashcardpojo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Options {

    private final boolean allowDuplicate;
    private final String duplicateScope;
    private final DuplicateScopeOptions duplicateScopeOptions;

}

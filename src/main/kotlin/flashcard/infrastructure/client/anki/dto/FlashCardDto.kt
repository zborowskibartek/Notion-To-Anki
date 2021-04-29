package flashcard.infrastructure.client.anki.dto

data class FlashCardDto(
        private var action: String,
        private var version: Int,
        private var params: ParamsDto)

data class ParamsDto(
        private var note: NoteDto
)

data class NoteDto(
        private var deckName: String,
        private var modelName: String,
        private var fields: FieldsDto,
        private var options: OptionsDto
)

data class FieldsDto(
        private var Front: String,
        private var Back: String
)

data class OptionsDto(
        private var allowDuplicate: Boolean,
        private var duplicateScope: String,
        private var duplicateScopeOptions: DuplicateScopeOptionsDto
)

data class DuplicateScopeOptionsDto(
        private var deckName: String,
        private var checkChildren: Boolean
)

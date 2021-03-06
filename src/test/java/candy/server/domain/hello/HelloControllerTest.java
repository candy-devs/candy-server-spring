package candy.server.domain.hello;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static com.epages.restdocs.apispec.ResourceDocumentation.resource;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import candy.server.domain.hello.dto.HelloRequestDto;
import com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper;
import com.epages.restdocs.apispec.ResourceSnippetParameters;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders;
import org.springframework.restdocs.payload.JsonFieldType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureRestDocs
@AutoConfigureMockMvc
public class HelloControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void checkGetApi() throws Exception {
        mockMvc.perform(RestDocumentationRequestBuilders.get("/api/v1/hello")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andDo(MockMvcRestDocumentationWrapper.document("hello-get",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        resource(
                                ResourceSnippetParameters.builder()
                                        .description("Hello ????????? GET?????? ???????????????.")
                                        .summary("Hello ?????? ??????")
                                        .responseFields(
                                                fieldWithPath("value").type(JsonFieldType.STRING)
                                                        .description("???????????? ?????????"),
                                                fieldWithPath("success").type(JsonFieldType.BOOLEAN)
                                                        .description("?????? ????????? ???????????? ?????? ??????"),
                                                fieldWithPath("createdOn").type(
                                                                JsonFieldType.STRING)
                                                        .description("?????? ?????? ??????")
                                        )
                                        .build()
                        )
                ));
    }

    @Test
    public void checkPostApi() throws Exception {
        HelloRequestDto requestDto = HelloRequestDto.builder()
                .stringValue("example")
                .intValue(1L)
                .build();
        String requestBody = objectMapper.writeValueAsString(requestDto);

        mockMvc.perform(RestDocumentationRequestBuilders.post("/api/v1/hello")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody))
                .andDo(print())
                .andExpect(status().is(200))
                .andDo(document("hello-create",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint()),
                        resource(
                                ResourceSnippetParameters.builder()
                                        .description("Hello ????????? POST??? ????????????.")
                                        .summary("Hello ?????? ??????")
                                        .requestFields(
                                                fieldWithPath("stringValue").type(
                                                        JsonFieldType.STRING).description("????????? ???"),
                                                fieldWithPath("intValue").type(JsonFieldType.NUMBER)
                                                        .description("?????? ???")
                                        )
                                        .responseFields(
                                                fieldWithPath("value").type(JsonFieldType.STRING)
                                                        .description("???????????? ?????????"),
                                                fieldWithPath("success").type(JsonFieldType.BOOLEAN)
                                                        .description("?????? ????????? ???????????? ?????? ??????"),
                                                fieldWithPath("createdOn").type(
                                                                JsonFieldType.STRING)
                                                        .description("?????? ?????? ??????")
                                        )
                                        .build()
                        )
                ));
    }
}

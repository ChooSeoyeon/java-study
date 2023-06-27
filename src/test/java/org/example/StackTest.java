package org.example;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.class)
@DisplayName("int 배열 Stack Test")
public class StackTest {

    Stack stack;

    @BeforeAll
    void init() {

        stack = new Stack();
        for(int i=0; i<3; i++) {
            stack.push(i*10);
        }
    }

    @Test
    @DisplayName("push 테스트")
    void pushTest() {
        assertEquals("0,10,20,30,", stack.toString());
    }
}

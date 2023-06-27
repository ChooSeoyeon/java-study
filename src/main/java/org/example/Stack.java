package org.example;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {

    int[] stack; // int 배열을 사용해서 정수를 저장하는 stack
    int top; // 삽입과 삭제가 일어나는 위치
    static final int DEFAULT_CAPACITY = 5; // 최소 용량 크기

    // 생성자
    public Stack() {

        this.stack = new int[DEFAULT_CAPACITY]; // null로 초기화
        this.top = -1;
    }

    // top 위치에 새로운 데이터를 삽입하는 연산
    public void push(int data) {

        if(isFull()) {
            resize();
        }
        else stack[++top] = data;
    }

    // top 위치에 현재 있는 데이터를 삭제하고 확인하는 연산
    public int pop() {

        if(isEmpty()) {
            throw new EmptyStackException();
        }
        int value = stack[top];
        stack[top] = 0; // 굳이 필요한가?
        top--;
        resize();
        return value;
    }

    // top 위치에 현재 있는 데이터를 단순 확인하는 연산
    public int peek() {

        if(isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top];
    }

    // 스택이 비어있는지 확인하는 연산
    public boolean isEmpty() {

        return (top == -1);
    }

    // 스택이 꽉 찼는지 확인하는 연산
    public boolean isFull() {

        return (top == stack.length - 1); // top이 마지막 인덱스면 true 반환
    }

    // 스택 꽉 찼을 때 배열 크기 늘리는 내부 연산(가변 배열 처리)
    private void resize() {

        int capacity = stack.length - 1; // 용량 (top과 비교할 거라서 0부터 시작하는 인덱스 기준으로 용량 카운트)

        // 용량이 꽉 찬 경우, 2배로 늘림
        if(top == capacity) {
            stack = Arrays.copyOf(stack, stack.length * 2); // 새 용량 만큼 설정하고 기존 원소들을 복사해서 넣고 반환 (빈공간은 null)
        }

        // 용량에 비해 데이터 양이 적은 경우, 1/2배로 줄임
        if(top < (capacity/2)) {
            stack = Arrays.copyOf(stack, Math.max(stack.length / 2, DEFAULT_CAPACITY)); // 새 용량과 디폴트 용량 중 큰 거만큼 설정
        }
    }

    public String toString() {

        String result = "";
        if (isEmpty()) return result;
        for (int x : stack) {
            result += String.valueOf(x + ',');
        }
        return result; //.substring(0, result.length()-1);
    }
}

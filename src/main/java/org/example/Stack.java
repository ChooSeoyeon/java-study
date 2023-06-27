package org.example;

public class Stack {

    int[] stack; // int 배열을 사용해서 정수를 저장하는 stack
    int size; // stack 배열의 크기
    int top; // 삽입과 삭제가 일어나는 위치

    // 생성자
    public Stack(int size) {

        this.stack = new int[size]; // null로 초기화
        this.size = size;
        this.top = -1;
    }

    // top 위치에 새로운 데이터를 삽입하는 연산
    public void push(int data) {

        if(isFull()) System.out.println("Stack is full");
        else stack[++top] = data;
    }

    // top 위치에 현재 있는 데이터를 삭제하고 확인하는 연산
    public int pop() {

        if(isEmpty()) return -1;
        return stack[top--];
    }

    // top 위치에 현재 있는 데이터를 단순 확인하는 연산
    public int peek() {

        return stack[top];
    }

    // 스택이 비어있는지 확인하는 연산
    public boolean isEmpty() {

        return (top==-1);
    }

    // 스택이 꽉 찼는지 확인하는 연산
    public boolean isFull() {

        return (top==size-1); // top이 마지막 인덱스면 true 반환
    }
}

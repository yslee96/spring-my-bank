1. Account 구현
BaseAccount 인터페이스를 상속하는 MyAccount 클래스를 구현하세요
MyAccount 클래스는 계좌 한 개의 정보를 저장하고 있습니다
잔액 외에도 계좌에 필요하다고 생각되는 정보를 추가해보세요

2. Bank 구현
BaseBank 인터페이스를 상속하는 MyBank 클래스를 구현하세요
BaseBank 인터페이스의 Generic T는 계좌를 저장하는 구조체 타입을 지정합니다(LinkedList, HashMap 등)
MyBank 클래스는 은행 하나의 계좌 정보를 모두 저장하고 있습니다

3. xml 작성
은행 빈을 작성하세요
계좌를 저장할 구조체를 만들기 위해 util 스키마를 사용하세요
최소 두개 이상의 계좌를 생성하세요

4. application context (추후 test로 대체)
MyBankApplication.java에서 은행 빈을 생성하세요
입금, 출금, 잔고보다 많은 금액 출금을 테스트해보세요
송금, 없는 계좌로 송금, 잔고보다 많은 금액 송금을 테스트해보세요

** 추가 **
Account를 생성하는 팩토리 메소드를 구현해서 빈을 생성해 보세요
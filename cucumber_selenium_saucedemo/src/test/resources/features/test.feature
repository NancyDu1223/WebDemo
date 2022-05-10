Feature: Login add Cart and Check Out
  Background:
    Given launch sauce application

  Scenario: LoginPage
    Given openLogPage
#    When login # 自动获取随机账号
     # 登录失败，错误的账号密码
    When loginByAccountAndPassword "xxx" "yyy"
     # 没法添加$49.99的商品，填写信息也会出现问题的
#    When loginByAccountAndPassword "problem_user" "secret_sauce"
     # 测试正常
#    When loginByAccountAndPassword "standard_user" "secret_sauce"
    When checkLoginResult

  Scenario: Get Product List
    Given getProducts
    Given productsPageGoToShoppingCart

  Scenario: CartPage
    Given cartPageCartItemLabel
    Given checkout

  Scenario: Checkout
#    Given checkoutPageInputCheckoutInfo
    When checkoutPageInputCheckoutInfo "li" "si" "888888"
    When checkoutPageSubmit

  Scenario: Check Page info
    Given finishPageCheckoutSummaryContainer
    Given finishPageCheckout

  Scenario: Finish Checkout
    Given exit


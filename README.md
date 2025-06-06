# Agent 项目

## 项目简介

Agent 是一个基于 Spring Boot 和 LangChain4j 开发的智能代理系统，集成了大语言模型能力，可以处理自然语言查询并提供智能响应。该项目使用 MongoDB 存储聊天记忆，MySQL 存储结构化数据，提供了完整的 Web 接口供用户交互。

## 技术栈

- **后端框架**：Spring Boot 3.2.6
- **AI 集成**：LangChain4j 1.0.0-beta3
- **数据库**：
  - MongoDB（聊天记忆存储）
  - MySQL（结构化数据存储）
- **ORM 框架**：MyBatis-Plus 3.5.11
- **API 文档**：Knife4j 4.3.0
- **其他**：Lombok, WebFlux

## 系统要求

- JDK 17 或更高版本
- Maven 3.6 或更高版本
- MySQL 数据库
- MongoDB 数据库

## 快速开始

### 1. 克隆项目

```bash
git clone [项目仓库地址]
cd Agent
```

### 2. 配置数据库

确保已安装并启动 MySQL 和 MongoDB 服务，然后根据 `application.yaml` 中的配置修改数据库连接信息：

```yaml
spring:
  data:
    mongodb:
      uri: mongodb://localhost:27017/chat_memory_db
  datasource:
    url: jdbc:mysql://localhost:3306/CampusEase?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false
    username: root
    password: 12345678
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### 3. 配置 AI 模型

在 `application.yaml` 中配置您的 AI 模型 API 密钥和基础 URL：

```yaml
langchain4j:
  open-ai:
    streaming-chat-model:
      model-name: deepseek-chat
      api-key: [您的API密钥]
      base-url: [API基础URL]
```

### 4. 构建项目

```bash
mvn clean package
```

### 5. 运行项目

```bash
java -jar target/Agent-1.0-SNAPSHOT.jar
```

或者使用 Maven 运行：

```bash
mvn spring-boot:run
```

### 6. 访问应用

应用启动后，可以通过以下地址访问：

- 主应用：http://localhost:8080
- API 文档：http://localhost:8080/doc.html

## 项目结构

```
src/main/java/com/gsh/
├── assistant/    # AI 助手相关代码
├── bean/         # 通用 Bean 定义
├── config/       # 配置类
├── controller/   # API 控制器
├── entity/       # 数据实体类
├── mapper/       # MyBatis 映射器
├── service/      # 业务逻辑服务
├── store/        # 数据存储相关
├── tools/        # 工具类
└── main.java     # 应用入口
```

## 功能特性

- 集成大语言模型进行自然语言处理
- 支持流式响应
- 聊天记忆持久化
- RESTful API 接口
- 完整的 API 文档

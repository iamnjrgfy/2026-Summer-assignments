# 基隆景點瀏覽器 (Keelung Sights Browser)

這是一個基於 **Spring Boot** 與 **MongoDB Atlas** 開發的後端系統，結合前端網頁提供使用者快速查詢各地區基隆景點、檢視詳細資訊的互動式平台。

---

## 1. 系統功能

1. **景點資料自動初始化**：系統啟動時自動檢查資料庫，若為空則執行爬蟲匯入預設景點資料。
2. **區域景點查詢**：支援依行政區（七堵、中山、中正、仁愛、安樂、信義、暖暖）快速篩選並回傳 JSON 景點清單。
3. **雲端資料庫支援**：採用 MongoDB Atlas 雲端資料庫，確保資料持久化與高可用性。
4. **即時前端互動**：透過 AJAX 技術實現非同步資料載入，提供流暢的瀏覽體驗。
5. **智慧防呆機制**：內建圖片載入錯誤處理，若原始資料缺失圖片，自動替換為預設圖片，並確保 API 回傳標準 HTTP 狀態碼 (404/200)。

---

## 2. 架構概覽

本專案採用經典的 **三層式架構 (Layered Architecture)**：

* **Controller 層**：處理 HTTP 請求並執行路由映射，回傳結構化的 JSON 資料。
* **Service 層**：處理商業邏輯，包含行政區代號對應、資料庫空值校驗與爬蟲觸發機制。
* **Repository 層**：透過 Spring Data MongoDB 執行資料庫的 CRUD 操作。
* **Database**：MongoDB Atlas (NoSQL 雲端集群)。

---

## 3. 環境需求

* **JDK**：17 或以上版本
* **Spring Boot**：4.1.0
* **Maven**：3.8+

## 4. API 範例

* **取得指定區域景點**
    * **請求方法**：`GET`
    * **API 路徑**：`https://2026-summer-assignments-production.up.railway.app/api/sights/{zone}`
    * **請求範例**：`https://2026-summer-assignments-production.up.railway.app/api/sights/qidu`

## 5. 安裝與執行步驟

1. **複製專案**：`git clone [https://github.com/iamnjrgfy/2026-Summer-assignments.git]`
2. **進路hw5** : `cd hw5`
2. **設定環境變數**：確保系統環境變數設定了 `SPRING_DATA_MONGODB_URI`。
3. **建置專案**：在專案目錄下執行 `mvn clean install`。
4. **執行程式**：執行 `mvn spring-boot:run`。
5. **前端測試**：使用 Live Server 開啟 `index.html` 即可進行互動測試。

## 6. 公開網址
* **專案網址**：[https://2026-summer-assignments-production.up.railway.app/](https://2026-summer-assignments-production.up.railway.app/)

## 7. 已知限制
* **圖片載入**：原始爬取資料若無圖片網址，將自動載入預設圖片服務。若外部圖庫連線不穩定，顯示可能受到影響。
* **瀏覽器相容性**：建議使用最新版 Chrome 或 Edge 進行瀏覽以獲得最佳排版效果。
// Databricks notebook source
dbutils.fs.mkdirs("/mnt/dados")

// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt")

// COMMAND ----------

val configs = Map(
  "fs.azure.account.auth.type" -> "OAuth",
  "fs.azure.account.oauth.provider.type" -> "org.apache.hadoop.fs.azurebfs.oauth2.ClientCredsTokenProvider",
  "fs.azure.account.oauth2.client.id" -> "acad94c2-4baa-4432-94cf-aba353334a8f",
  "fs.azure.account.oauth2.client.secret" -> "MQT8Q~aHf~JWabcLMnsckj1Pw6g2X4okJcHpcaEB",
  "fs.azure.account.oauth2.client.endpoint" -> "https://login.microsoftonline.com/47353336-61c5-4b22-85e4-f25a6eac5fd1/oauth2/token")
// Optionally, you can add <directory-name> to the source URI of your mount point.
dbutils.fs.mount(
  source = "abfss://imoveis@dakaealura.dfs.core.windows.net/",
  mountPoint = "/mnt/dados",
  extraConfigs = configs)


// COMMAND ----------

// MAGIC %python
// MAGIC dbutils.fs.ls("/mnt/dados")

// COMMAND ----------



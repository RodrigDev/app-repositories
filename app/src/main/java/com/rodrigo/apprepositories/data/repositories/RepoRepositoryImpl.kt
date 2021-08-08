package com.rodrigo.apprepositories.data.repositories

import com.rodrigo.apprepositories.core.RemoteException
import com.rodrigo.apprepositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GitHubService) : RepoRepository {

    override suspend fun listRepositories(User: String) = flow {
        try {
            val repoList = service.listRepositories(User)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possivel fazer a busca no momento!")
        }
    }
}
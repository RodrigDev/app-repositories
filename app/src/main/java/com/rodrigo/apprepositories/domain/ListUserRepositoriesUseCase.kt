package com.rodrigo.apprepositories.domain

import com.rodrigo.apprepositories.core.UseCase
import com.rodrigo.apprepositories.data.model.Repo
import com.rodrigo.apprepositories.data.repositories.RepoRepository
import kotlinx.coroutines.flow.Flow

class ListUserRepositoriesUseCase(
    private val repository: RepoRepository
) : UseCase<String, List<Repo>>() {

    override suspend fun execute(param: String): Flow<List<Repo>> {
        return repository.listRepositories(param)
    }
}
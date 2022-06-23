package com.onedev.demo.controller

import com.onedev.demo.entity.Book
import com.onedev.demo.response.BaseResponse
import com.onedev.demo.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/book")
class BookController {

    @Autowired
    private lateinit var bookService: BookService

    @GetMapping
    fun getBooks(): BaseResponse<List<Book>> {
        val data = bookService.getBooks()
        return if (data.isNotEmpty()) {
            BaseResponse(
                message = "Success Retrieve Data",
                status = true,
                data = bookService.getBooks()
            )
        } else {
            BaseResponse(
                message = "Failed Retrieve Data",
                status = false,
                data = null
            )
        }
    }

    @GetMapping("/id")
    fun getBookById(
        @RequestParam id: String
    ): BaseResponse<Book> {
        val data = bookService.getBookById(id)
        return if (data != null) {
            BaseResponse(
                message = "Success Retrieve Data",
                status = true,
                data = data
            )
        } else {
            BaseResponse(
                message = "Book With Id : $id Not Found!",
                status = false,
                data = null
            )
        }
    }

    @GetMapping("/userId")
    fun getBooksByUserId(
        @RequestParam userId: String
    ): BaseResponse<List<Book>> {
        val data = bookService.getBooksByUserId(userId)
        return if (data.isNotEmpty()) {
            BaseResponse(
                message = "Success Retrieve Data",
                status = true,
                data = data
            )
        } else {
            BaseResponse(
                message = "Book With User Id : $userId Not Found!",
                status = false,
                data = null
            )
        }
    }

    @PostMapping
    fun addBook(
        @RequestBody book: Book
    ): BaseResponse<List<Book>> {
        return BaseResponse(
            message = "Success Add Data Book",
            status = true,
            data = bookService.addBook(book)
        )
    }

    @PutMapping("/{id}")
    fun updateBook(
        @PathVariable id: String,
        @RequestBody book: Book
    ): BaseResponse<Book> {
        return BaseResponse(
            message = "Success Update Data Book",
            status = true,
            data = bookService.updateBook(id, book)
        )
    }

    @DeleteMapping("/{id}")
    fun deleteBook(
        @PathVariable id: String,
    ): BaseResponse<Book> {
        return BaseResponse(
            message = "Success Delete Data Book",
            status = true,
            data = bookService.deleteBook(id)
        )
    }
}
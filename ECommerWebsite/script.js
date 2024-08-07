document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = 'https://dummyjson.com';
    let currentPage = 1;
    let limit = 20;
    let totalProducts = 0;
    let currentCategory = '';
    let isFetching = false; // To prevent multiple simultaneous fetch requests

    const searchBar = document.getElementById('search-bar');
    const searchBtn = document.getElementById('search-btn');
    const categoriesSection = document.getElementById('categories');
    const productList = document.getElementById('product-list');
    const limitSelect = document.getElementById('limit-select');
    const prevBtn = document.getElementById('prev-btn');
    const nextBtn = document.getElementById('next-btn');
    const pageNumber = document.getElementById('page-number');
    const parentProduct = document.getElementById('product-parent');
    const paginationNumbers = document.getElementById('pagination-numbers');

    searchBtn.addEventListener('click', searchProduct);
    limitSelect.addEventListener('change', updateLimit);
    prevBtn.addEventListener('click', () => changePage(-1));
    nextBtn.addEventListener('click', () => changePage(1));
    parentProduct.addEventListener('scroll', handleScroll);

    function fetchCategories() {
        fetch(`${apiUrl}/products/categories`)
            .then(response => response.json())
            .then(categories => {
                categories.forEach(category => {
                    const categoryDiv = document.createElement('div');
                    categoryDiv.textContent = category['name'];
                    categoryDiv.addEventListener('click', () => fetchProductsByCategory(category['slug']));
                    categoriesSection.appendChild(categoryDiv);
                });
            })
            .catch(error => console.error('Error fetching categories:', error));
    }

    function fetchProducts(limit, skip, category = '', append = false) {
        isFetching = true;
        let url = `${apiUrl}/products`;
        if (category) {
            url += `/category/${category}`;
        }
        url += `?limit=${limit}&skip=${skip}`;
        fetch(url)
            .then(response => response.json())
            .then(data => {
                totalProducts = data.total;
                displayProducts(data.products, append);
                updatePagination();
                isFetching = false;
            })
            .catch(error => {
                console.error('Error fetching products:', error);
                isFetching = false;
            });
    }

    function searchProduct() {
        const query = searchBar.value;
        if (query) {
            fetch(`${apiUrl}/products/search?q=${query}`)
                .then(response => response.json())
                .then(data => {
                    displayProducts(data.products);
                    updatePagination();
                })
                .catch(error => console.error('Error searching products:', error));
        }
    }

    function fetchProductsByCategory(category) {
        currentCategory = category;
        currentPage = 1;
        fetchProducts(limit, 0, category);
    }

    function displayProducts(products, append = false) {
        if (!append) {
            productList.innerHTML = '';
        }
        products.forEach(product => {
            const productCard = document.createElement('div');
            productCard.className = 'product-card';
            productCard.dataset.page = Math.ceil((productList.children.length + 1) / limit); // Track which page the product belongs to
            productCard.innerHTML = `
                <img src="${product.thumbnail}" alt="${product.title}">
                <h3>${product.title}</h3>
                <p>${product.description}</p>
                <p>$${product.price}</p>
            `;
            productCard.addEventListener('click', () => fetchProductDetails(product.id));
            productList.appendChild(productCard);
        });
        observeProductCards();
    }

    function fetchProductDetails(id) {
        fetch(`${apiUrl}/products/${id}`)
            .then(response => response.json())
            .then(product => {
                productList.innerHTML = `
                    <div class="product-card">
                        <img src="${product.images[0]}" alt="${product.title}">
                        <h3>${product.title}</h3>
                        <p>${product.description}</p>
                        <p>$${product.price}</p>
                        <p>${product.category}</p>
                        <p>Stock: ${product.stock}</p>
                    </div>
                `;
            })
            .catch(error => console.error('Error fetching product details:', error));
    }

    function updateLimit() {
        limit = +limitSelect.value, 10;
        fetchProducts(limit, 0, currentCategory);
    }

    function changePage(direction) {
        if (currentPage < 1) {
            prevBtn.disabled = true;
        } else {
            prevBtn.disabled = false;
        }
        if ((direction === -1 && currentPage > 1) || (direction === 1 && (currentPage * limit) < totalProducts)) {
            currentPage += direction;
            fetchProducts(limit, (currentPage - 1) * limit, currentCategory);
        }
    }

    function handleScroll() {
        const { scrollTop, scrollHeight, clientHeight } = parentProduct;
        if (scrollTop + clientHeight >= scrollHeight - 50 && !isFetching) {
            currentPage++;
            fetchProducts(limit, (currentPage - 1) * limit, currentCategory, true);
        }
    }


    function updatePagination() {
        pageNumber.textContent = `${currentPage}`;

        // Clear previous pagination numbers
        paginationNumbers.innerHTML = '';

        const totalPages = Math.ceil(totalProducts / limit);
        const maxVisiblePages = 5; // Number of visible page numbers

        let startPage = Math.max(1, currentPage - Math.floor(maxVisiblePages / 2));
        let endPage = Math.min(totalPages, startPage + maxVisiblePages - 1);

        if (endPage - startPage + 1 < maxVisiblePages) {
            startPage = Math.max(1, endPage - maxVisiblePages + 1);
        }

        for (let i = startPage; i <= endPage; i++) {
            const pageLink = document.createElement('button');
            pageLink.textContent = i;
            pageLink.style.cursor = 'pointer';
            pageLink.className = (i === currentPage) ? 'active' : '';
            pageLink.addEventListener('click', () => goToPage(i));
            paginationNumbers.appendChild(pageLink);
        }
    }

    function goToPage(page) {
        if (page !== currentPage && page >= 1 && page <= Math.ceil(totalProducts / limit)) {
            currentPage = page;
            fetchProducts(limit, (currentPage - 1) * limit, currentCategory);
        }
    }

    function observeProductCards() {
        const options = {
            root: parentProduct,
            rootMargin: '0px',
            threshold: 0.5 // Adjust this as necessary
        };

        const callback = (entries) => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    const visibleProductCard = entry.target;
                    const visiblePage = parseInt(visibleProductCard.dataset.page, 10);
                    if (visiblePage !== currentPage) {
                        currentPage = visiblePage;
                        updatePagination();
                    }
                }
            });
        };

        const observer = new IntersectionObserver(callback, options);

        document.querySelectorAll('.product-card').forEach(card => {
            observer.observe(card);
        });
    }

    // Initial fetch
    fetchCategories();
    fetchProducts(limit, 0);
});

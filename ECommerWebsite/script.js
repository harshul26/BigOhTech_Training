//scripts.js

document.addEventListener('DOMContentLoaded', () => {
    const apiUrl = 'https://dummyjson.com';
    let currentPage = 1;
    let limit = 20;
    let totalProducts = 0;
    let currentCategory = '';
    let searchQuery = '';

    const searchBar = document.getElementById('search-bar');
    const searchBtn = document.getElementById('search-btn');
    const categoriesSection = document.getElementById('categories');
    const productList = document.getElementById('product-list');
    const limitSelect = document.getElementById('limit-select');
    const prevBtn = document.getElementById('prev-btn');
    const nextBtn = document.getElementById('next-btn');
    const loadMoreBtn = document.getElementById('load-more-btn');

    searchBtn.addEventListener('click', searchProduct);
    limitSelect.addEventListener('change', updateLimit);
    prevBtn.addEventListener('click', () => changePage(-1));
    nextBtn.addEventListener('click', () => changePage(1));
    loadMoreBtn.addEventListener('click', loadMoreProducts);

    function fetchCategories() {
        fetch(`${apiUrl}/products/categories`)
            .then((response) => response.json())
            .then((categories) => {
                categories.forEach((category) => {
                    const categoryDiv = document.createElement('div');
                    categoryDiv.textContent = category['name']; // Display the category name
                    categoryDiv.addEventListener('click', () => fetchProductsByCategory(category['name']));
                    categoriesSection.appendChild(categoryDiv);
                });
            })
            .catch(error => console.error('Error fetching categories:', error));
    }

    function fetchProducts(limit, skip, category = '', search = '', append = false) {
        let url = `${apiUrl}/products?limit=${limit}&skip=${skip}`;
        if (category) {
            url = `${apiUrl}/products/category/${category}?limit=${limit}&skip=${skip}`;
        }
        if (search) {
            url = `${apiUrl}/products/search?q=${search}&limit=${limit}&skip=${skip}`;
        }
        fetch(url)
            .then(response => response.json())
            .then(data => {
                totalProducts = data.total;
                displayProducts(data.products, append);
            })
            .catch(error => console.error('Error fetching products:', error));
    }

    function searchProduct() {
        searchQuery = searchBar.value;
        currentPage = 1;
        fetchProducts(limit, 0, currentCategory, searchQuery);
    }

    function fetchProductsByCategory(category) {
        currentPage = 1;
        currentCategory = category;
        searchQuery = '';
        fetchProducts(limit, 0, category, searchQuery);
    }

    function displayProducts(products, append = false) {
        if (!append) {
            productList.innerHTML = '';
        }
        products.forEach(product => {
            const productCard = document.createElement('div');
            productCard.className = 'product-card';
            productCard.innerHTML = `
                <img src="${product.thumbnail}" alt="${product.title}">
                <h3>${product.title}</h3>
                <p>${product.description}</p>
                <p>$${product.price}</p>
            `;
            productCard.addEventListener('click', () => fetchProductDetails(product.id));
            productList.appendChild(productCard);
        });
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
        limit = parseInt(limitSelect.value, 10);
        currentPage = 1;
        fetchProducts(limit, 0, currentCategory, searchQuery);
    }

    function changePage(direction) {
        if ((direction === -1 && currentPage > 1) || (direction === 1 && (currentPage * limit) < totalProducts)) {
            currentPage += direction;
            fetchProducts(limit, (currentPage - 1) * limit, currentCategory, searchQuery);
        }
    }

    function loadMoreProducts() {
        const skip = currentPage * limit;
        currentPage += 1;
        fetchProducts(limit, skip, currentCategory, searchQuery, true);
    }

    // Initial fetch
    fetchCategories();
    fetchProducts(limit, 0);
});

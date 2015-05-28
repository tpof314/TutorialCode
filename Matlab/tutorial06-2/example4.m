for n = 1 : 10
    for i=1:(10 - n)
        fprintf(' ');
    end
    
    for i = 1:n
        fprintf('*');
    end
    fprintf('\n');
end